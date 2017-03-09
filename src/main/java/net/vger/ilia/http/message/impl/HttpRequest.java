package net.vger.ilia.http.message.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.vger.ilia.common.HttpRequestMethod;
import net.vger.ilia.http.message.AbstractHttpMessage;
import net.vger.ilia.http.message.component.QueryParameter;

public class HttpRequest extends AbstractHttpMessage {

	private URL url;
	private HttpRequestMethod httpRequestMethod;
	private List<QueryParameter> queryParameters;

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public HttpRequestMethod getHttpRequestMethod() {
		return httpRequestMethod;
	}

	public void setHttpRequestMethod(HttpRequestMethod httpRequestType) {
		this.httpRequestMethod = httpRequestType;
	}
	
	public List<QueryParameter> getQueryParameters() {
		if (this.queryParameters == null) {
			this.queryParameters = new ArrayList<QueryParameter>();
		}
		return this.queryParameters;
	}

	public void setQueryParameters(List<QueryParameter> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public void addQueryParameter(QueryParameter queryParameter) {
		getQueryParameters().add(queryParameter);
	}

	public void addQueryParameters(List<QueryParameter> queryParameters) {
		getQueryParameters().addAll(queryParameters);
	}

	public void removeQueryParameter(QueryParameter queryParameter) {
		getQueryParameters().remove(queryParameter);
	}

	public void removeQueryParameters(List<QueryParameter> queryParameters) {
		getQueryParameters().removeAll(queryParameters);
	}

	public void clearQueryParameters() {
		this.queryParameters = null;
	}

}
