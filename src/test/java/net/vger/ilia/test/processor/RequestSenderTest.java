package net.vger.ilia.test.processor;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import org.apache.http.HttpResponse;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;

import net.vger.ilia.core.RequestResponse;
import net.vger.ilia.core.deserializer.YamlDeserializer;
import net.vger.ilia.core.engine.RequestSender;

public class RequestSenderTest {

	private static Logger LOG = LoggerFactory.getLogger(RequestSenderTest.class);
	
	@ClassRule
	public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

	@Rule
	public WireMockClassRule instanceRule = wireMockRule;

	@Test
	public void testRequestSender() {
		try {
			RequestResponse rr = YamlDeserializer.deserialize("unitTest.yml");
			wireMockRule.stubFor(post(urlMatching("/resource.*"))
					.withHeader("Accept", equalTo("text/json"))
					.withQueryParam(rr.getRequest().getQueryParameters().get(0).getName(), equalTo(rr.getRequest().getQueryParameters().get(0).getValue()))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "text/json")
							.withBody("Some content")));
			HttpResponse response = RequestSender.sendRequest(rr.getRequest());
			LOG.debug(response.toString());
			//do matching here of the response
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
