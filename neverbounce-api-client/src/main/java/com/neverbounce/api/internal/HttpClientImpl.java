package com.neverbounce.api.internal;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonParser;
import com.neverbounce.api.client.exception.NeverbounceApiException;
import com.neverbounce.api.client.exception.NeverbounceIOException;
import com.neverbounce.api.model.Response;
import java.io.IOException;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class HttpClientImpl implements HttpClient {

  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

  private final HttpRequestFactory requestFactory;

  public HttpClientImpl(String apiKey) {
    this(apiKey, HTTP_TRANSPORT);
  }

  HttpClientImpl(String apiKey, HttpTransport httpTransport) {
    HttpRequestInitializer httpRequestInitializer = new DefaultHttpRequestInitializer(apiKey);
    requestFactory = httpTransport.createRequestFactory(httpRequestInitializer);
  }

  @Override
  public <R extends Response> R getForObject(String path, Class<R> responseClass) {
    GenericUrl url = new GenericUrl(API_BASE_URL + "/" + path);

    try {
      HttpRequest request = requestFactory.buildGetRequest(url);
      return request.execute().parseAs(responseClass);
    } catch (HttpResponseException hre) {
      throw translateHttpResponseException(hre);
    } catch (IOException ioe) {
      throw new NeverbounceIOException(ioe);
    }
  }

  private RuntimeException translateHttpResponseException(HttpResponseException hre) {
    NeverbounceApiException neverbounceApiException;
    try {
      JsonParser jsonParser = JSON_FACTORY.createJsonParser(hre.getContent());
      neverbounceApiException = jsonParser.parse(NeverbounceApiException.class);
    } catch (IOException ioe) {
      return new NeverbounceIOException(ioe);
    }

    return neverbounceApiException;
  }

}
