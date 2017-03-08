package net.vger.ilia.http.message.impl;

import net.vger.ilia.common.HttpRequestMethod;
import net.vger.ilia.http.message.AbstractHttpMessage;

public class HttpRequest extends AbstractHttpMessage {

	private HttpRequestMethod httpRequestMethod;

	public HttpRequestMethod getHttpRequestMethod() {
		return httpRequestMethod;
	}

	public void setHttpRequestMethod(HttpRequestMethod httpRequestType) {
		this.httpRequestMethod = httpRequestType;
	}

}
