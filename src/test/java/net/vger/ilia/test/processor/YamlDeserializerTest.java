package net.vger.ilia.test.processor;

import org.junit.Test;

import net.vger.ilia.core.deserializer.YamlDeserializer;

public class YamlDeserializerTest {

	@Test
	public void testYamlDeserializer() {
		try {
			YamlDeserializer.deserialize("unitTest.yml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
