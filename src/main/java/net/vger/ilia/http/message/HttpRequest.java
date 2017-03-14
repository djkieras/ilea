package net.vger.ilia.http.message;

import java.net.URL;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.vger.ilia.common.HttpRequestMethod;
import net.vger.ilia.http.message.component.QueryParameter;

@XmlRootElement(name="request")
public interface HttpRequest extends HttpMessage {

	@JsonProperty(required=true, value="url")
	URL getUrl();
	
	void setUrl(URL url);
	
	@JsonProperty(required=true, value="method")
	HttpRequestMethod getHttpRequestMethod();
	
	void setHttpRequestMethod(HttpRequestMethod httpRequestType);
	
	@JsonProperty(required=true, value="queryParameters")
	List<QueryParameter> getQueryParameters();
	
	void setQueryParameters(List<QueryParameter> queryParameters);
	
	void addQueryParameter(QueryParameter queryParameter);
	
	void addQueryParameters(List<QueryParameter> queryParameters);
	
	void removeQueryParameter(QueryParameter queryParameter);
	
	void removeQueryParameters(List<QueryParameter> queryParameters);
	
	void clearQueryParameters();
	
}
