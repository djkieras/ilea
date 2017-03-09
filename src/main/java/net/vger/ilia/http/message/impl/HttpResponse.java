package net.vger.ilia.http.message.impl;

import net.vger.ilia.http.message.AbstractHttpMessage;

public class HttpResponse extends AbstractHttpMessage {

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
