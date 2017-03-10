package net.vger.ilia.http.message;

import java.net.URL;
import java.util.List;

import net.vger.ilia.common.HttpRequestMethod;
import net.vger.ilia.http.message.component.QueryParameter;

public interface HttpRequest extends HttpMessage {

	URL getUrl();
	
	void setUrl(URL url);
	
	HttpRequestMethod getHttpRequestMethod();
	
	void setHttpRequestMethod(HttpRequestMethod httpRequestType);
	
	List<QueryParameter> getQueryParameters();
	
	void setQueryParameters(List<QueryParameter> queryParameters);
	
	void addQueryParameter(QueryParameter queryParameter);
	
	void addQueryParameters(List<QueryParameter> queryParameters);
	
	void removeQueryParameter(QueryParameter queryParameter);
	
	void removeQueryParameters(List<QueryParameter> queryParameters);
	
	void clearQueryParameters();
	
}
