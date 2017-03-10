package net.vger.ilia.message.factory;

import net.vger.ilia.http.message.HttpRequest;
import net.vger.ilia.http.message.HttpResponse;
import net.vger.ilia.http.message.impl.SimpleHttpRequest;
import net.vger.ilia.http.message.impl.SimpleHttpResponse;

public class HttpMessageFactory {

	public HttpRequest createHttpRequest() {
		return new SimpleHttpRequest();
	}
	
	public HttpResponse createHttpResponse() {
		return new SimpleHttpResponse();
	}
	
}
