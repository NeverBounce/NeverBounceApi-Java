package com.neverbounce.api.internal;

import static com.neverbounce.api.model.Status.SUCCESS;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Data;
import com.neverbounce.api.client.exception.NeverbounceApiException;
import com.neverbounce.api.client.exception.NeverbounceIoException;
import com.neverbounce.api.model.Request;
import com.neverbounce.api.model.Response;
import com.neverbounce.api.model.Status;
import java.io.IOException;
import java.util.Map;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class HttpClientImpl implements HttpClient {

  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

  private final String apiKey;
  private final HttpRequestFactory requestFactory;

  public HttpClientImpl(String apiKey) {
    this(apiKey, HTTP_TRANSPORT);
  }

  HttpClientImpl(String apiKey, HttpTransport httpTransport) {
    this.apiKey = apiKey;

    HttpRequestInitializer httpRequestInitializer = new HttpRequestInitializer() {

      @Override
      public void initialize(HttpRequest httpRequest) throws IOException {
        httpRequest.setParser(JSON_FACTORY.createJsonObjectParser());
      }

    };

    requestFactory = httpTransport.createRequestFactory(httpRequestInitializer);
  }

  @Override
  public <R extends Response> R getForObject(String path, Class<R> responseClass) {
    return getForObject(path, null, responseClass);
  }

  @Override
  public <R extends Response> R getForObject(String path, Request<R> request, Class<R> responseClass) {
    GenericUrl url = new GenericUrl(API_BASE_URL + "/" + path);

    if (request != null) {
      Map<String, Object> requestData = Data.mapOf(request);
      url.putAll(requestData);
    }

    try {
      HttpRequest httpRequest = requestFactory.buildGetRequest(url);
      prepareRequest(httpRequest);

      R response = httpRequest.execute().parseAs(responseClass);
      Status status = response.getStatus();
      if (!SUCCESS.equals(status)) {
        throw new NeverbounceApiException(response);
      }

      return response;
    } catch (HttpResponseException hre) {
      throw translateHttpResponseException(hre);
    } catch (IOException ioe) {
      throw new NeverbounceIoException(ioe);
    }
  }

  private void prepareRequest(HttpRequest httpRequest) {
    String requestMethod = httpRequest.getRequestMethod();
    if (HTTP_METHOD_GET.equals(requestMethod)) {
      GenericUrl url = httpRequest.getUrl();
      url.set(API_KEY, apiKey);
      return;
    }

    if (HTTP_METHOD_POST.equals(requestMethod)) {
      // TODO: Add api_key as a new form parameter
      return;
    }

    throw new UnsupportedOperationException(
        "Cannot authenticate request for unimplemented HTTP method " + requestMethod
    );
  }

  private RuntimeException translateHttpResponseException(HttpResponseException hre) {
    NeverbounceApiException neverbounceApiException;
    try {
      JsonParser jsonParser = JSON_FACTORY.createJsonParser(hre.getContent());
      neverbounceApiException = jsonParser.parse(NeverbounceApiException.class);
    } catch (IOException ioe) {
      return new NeverbounceIoException(ioe);
    }

    return neverbounceApiException;
  }

}
