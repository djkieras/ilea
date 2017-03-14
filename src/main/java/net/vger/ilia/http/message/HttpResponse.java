package net.vger.ilia.http.message;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="response")
public interface HttpResponse extends HttpMessage {

	@JsonProperty(required=true, value="status")
	int getStatus();
	
	void setStatus(int status);
	
}
