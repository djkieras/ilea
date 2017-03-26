package net.vger.ilia.core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import net.vger.ilia.core.deserializer.SimpleYamlDeserializer;
import net.vger.ilia.core.http.message.HttpRequest;
import net.vger.ilia.core.http.message.HttpResponse;

@JsonDeserialize(using = SimpleYamlDeserializer.class)
public class RequestResponse {

	private HttpRequest request;
	private HttpResponse response;
	
	public RequestResponse() {
		
	}
	
	public RequestResponse(HttpRequest request, HttpResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public HttpRequest getRequest() {
		return request;
	}
	
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	
	public HttpResponse getResponse() {
		return response;
	}
	
	public void setResponse(HttpResponse response) {
		this.response = response;
	}
	
}
