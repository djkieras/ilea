package net.vger.ilia.processor;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import net.vger.ilia.core.RequestResponse;

public class YamlDeserializer {
	
	public static RequestResponse deserialize(String pathOnClass) throws JsonParseException, JsonMappingException, IOException {
		try (InputStream yamlInputStream = ClassLoader.getSystemResourceAsStream(pathOnClass)) {
			return deserialize(yamlInputStream);
		}
	}
	
	public static RequestResponse deserialize(InputStream yamlInputStream) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
		return objectMapper.readValue(yamlInputStream, RequestResponse.class);
	}

}
