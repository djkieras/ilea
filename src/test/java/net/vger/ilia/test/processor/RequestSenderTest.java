package net.vger.ilia.test.processor;

import org.junit.Test;

import net.vger.ilia.core.RequestResponse;
import net.vger.ilia.http.request.RequestSender;
import net.vger.ilia.processor.YamlDeserializer;

public class RequestSenderTest {

	@Test
	public void testRequestSender() {
		try {
			RequestResponse rr = YamlDeserializer.deserialize("unitTest.yml");
			RequestSender.sendRequest(rr.getRequest());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
