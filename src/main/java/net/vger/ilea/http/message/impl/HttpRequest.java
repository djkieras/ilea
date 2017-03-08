package net.vger.ilea.http.message.impl;

import net.vger.ilea.common.HttpRequestMethod;
import net.vger.ilea.http.message.AbstractHttpMessage;

public class HttpRequest extends AbstractHttpMessage {

	private HttpRequestMethod httpRequestMethod;

	public HttpRequestMethod getHttpRequestMethod() {
		return httpRequestMethod;
	}

	public void setHttpRequestMethod(HttpRequestMethod httpRequestType) {
		this.httpRequestMethod = httpRequestType;
	}

}
