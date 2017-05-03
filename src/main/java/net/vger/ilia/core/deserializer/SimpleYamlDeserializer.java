package net.vger.ilia.core.deserializer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.vger.ilia.core.RequestResponse;
import net.vger.ilia.core.http.message.HttpRequest;
import net.vger.ilia.core.http.message.HttpResponse;
import net.vger.ilia.core.http.message.impl.SimpleHttpRequest;
import net.vger.ilia.core.http.message.impl.SimpleHttpResponse;

public class SimpleYamlDeserializer extends StdDeserializer<RequestResponse> {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = LoggerFactory.getLogger(SimpleYamlDeserializer.class); 

	public SimpleYamlDeserializer() { 
        this(null); 
    } 
 
    public SimpleYamlDeserializer(Class<?> vc) { 
        super(vc); 
    }
    
	@Override
	public RequestResponse deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode mainNode = jsonParser.getCodec().readTree(jsonParser);
		
		JsonNode requestNode = mainNode.get("request");
		HttpRequest request = mapper.readValue(requestNode.traverse(mapper), SimpleHttpRequest.class);
		LOG.debug("HttpRequest = " + request);
		
		JsonNode responseNode = mainNode.get("response");
		HttpResponse response = mapper.readValue(responseNode.traverse(mapper), SimpleHttpResponse.class);
        LOG.debug("HttpResponse = " + response);
        //LOG.debug(mapper.readValue(response.getBody(), Map.class));
        
        LOG.debug("Response body as String: " + mapper.writeValueAsString(response.getBody()));
        LOG.debug("Response body class name: " + response.getBody().getClass().getName());
		return new RequestResponse(request, response);
		
	}

}