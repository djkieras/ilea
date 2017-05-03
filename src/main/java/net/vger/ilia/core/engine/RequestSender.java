package net.vger.ilia.core.engine;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.vger.ilia.core.http.message.HttpRequest;
import net.vger.ilia.core.model.NameValue;

public class RequestSender {

	private static Logger LOG = LoggerFactory.getLogger(RequestSender.class);
	
	public static HttpResponse sendRequest(HttpRequest request) throws Exception {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpRequestBase httpMethod = null;
			HttpResponse response;
			ObjectMapper mapper = new ObjectMapper();
			HttpEntity entity = new ByteArrayEntity(mapper.writeValueAsString(request.getBody()).getBytes());
			
			
//			String methodClass = "Http" + WordUtils.capitalize(request.getHttpRequestMethod().name().toLowerCase());
//			Class<?> clazz = Class.forName(methodClass);
//			HttpRequestBase httpMethod = (HttpRequestBase)clazz.newInstance();
			
			switch (request.getHttpRequestMethod().name()) {
			case HttpPost.METHOD_NAME:
				httpMethod = new HttpPost();
				break;
			case HttpGet.METHOD_NAME :
				httpMethod = new HttpGet();
				break;
			case HttpPut.METHOD_NAME :
				httpMethod = new HttpPut();
				break;
			case HttpDelete.METHOD_NAME :
				httpMethod = new HttpDelete();
				break;
			case HttpHead.METHOD_NAME :
				httpMethod = new HttpHead();
				break;
			default:
				break;
			}
			
			if (entity != null && httpMethod instanceof HttpEntityEnclosingRequest) {
				((HttpEntityEnclosingRequest)httpMethod).setEntity(entity);
			}
			URIBuilder uriBuilder = new URIBuilder(request.getUrl().toString());
			uriBuilder.setPort(request.getPort());
			for (NameValue nv : request.getQueryParameters()) {
				uriBuilder.addParameter(nv.getName(), nv.getValue());
			}
			httpMethod.setURI(uriBuilder.build());
			for (NameValue nv : request.getHttpHeaders()) {
				httpMethod.setHeader(nv.getName(), nv.getValue());
			}
			LOG.debug(httpMethod.toString());
			try (CloseableHttpResponse httpResponse = httpClient.execute(httpMethod)) {
				LOG.debug(httpResponse.toString());
				response = httpResponse;
			}
			return response;
		}
	}

}
