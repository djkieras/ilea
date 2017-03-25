package net.vger.ilia.test.processor;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import net.vger.ilia.core.RequestResponse;
import net.vger.ilia.http.request.RequestSender;
import net.vger.ilia.processor.YamlDeserializer;

public class RequestSenderTest {

	@ClassRule
	public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

	@Rule
	public WireMockClassRule instanceRule = wireMockRule;

	@Test
	public void testRequestSender() {
		try {
			RequestResponse rr = YamlDeserializer.deserialize("unitTest.yml");
			rr.getRequest().setUrl(new URL("http://localhost:8089/yo"));
			wireMockRule.stubFor(post(urlMatching("/yo.*"))
					.withHeader("Accept", equalTo("text/json"))
					.withQueryParam(rr.getRequest().getQueryParameters().get(0).getName(), equalTo(rr.getRequest().getQueryParameters().get(0).getValue()))
					.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "text/json")
							.withBody("Some content")));
			RequestSender.sendRequest(rr.getRequest());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
