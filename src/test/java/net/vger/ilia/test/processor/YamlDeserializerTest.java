package net.vger.ilia.test.processor;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.vger.ilia.core.deserializer.YamlDeserializer;

public class YamlDeserializerTest {

	private static Logger LOG = LoggerFactory.getLogger(YamlDeserializerTest.class);
	
	@Test
	public void testYamlDeserializer() {
		try {
			YamlDeserializer.deserialize("unitTest.yml");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			fail();
		}
	}
	
}
