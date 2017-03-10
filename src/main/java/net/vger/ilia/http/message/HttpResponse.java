package net.vger.ilia.http.message;

public interface HttpResponse extends HttpMessage {

	int getStatus();
	
	void setStatus(int status);
	
}
