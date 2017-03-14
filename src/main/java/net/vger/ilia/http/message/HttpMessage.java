package net.vger.ilia.http.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.vger.ilia.http.message.component.HttpHeader;

public interface HttpMessage {

	@JsonProperty(required=true, value="headers")
	List<HttpHeader> getHttpHeaders();
	
	void setHttpHeaders(List<HttpHeader> httpHeaders);
	
	void addHttpHeader(HttpHeader header);

	void addHttpHeaders(List<HttpHeader> headers);
	
	void removeHttpHeader(HttpHeader header);
	
	void removeHttpHeaders(List<HttpHeader> headers);
	
	void clearHttpHeaders();
	
	String getBody() ;

	void setBody(String body) ;

}
