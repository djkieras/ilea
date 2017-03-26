package net.vger.ilia.core.http.message.impl;

import net.vger.ilia.core.http.message.AbstractHttpMessage;
import net.vger.ilia.core.http.message.HttpResponse;

public class SimpleHttpResponse extends AbstractHttpMessage implements HttpResponse {

	private int status;

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public void setStatus(int status) {
		this.status = status;
	}
	
}
