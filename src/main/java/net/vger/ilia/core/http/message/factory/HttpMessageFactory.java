package net.vger.ilia.core.http.message.factory;

import net.vger.ilia.core.http.message.HttpRequest;
import net.vger.ilia.core.http.message.HttpResponse;
import net.vger.ilia.core.http.message.impl.SimpleHttpRequest;
import net.vger.ilia.core.http.message.impl.SimpleHttpResponse;

public class HttpMessageFactory {

	public HttpRequest createHttpRequest() {
		return new SimpleHttpRequest();
	}
	
	public HttpResponse createHttpResponse() {
		return new SimpleHttpResponse();
	}
	
}
