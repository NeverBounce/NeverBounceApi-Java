package com.neverbounce.api.internal;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import java.io.IOException;

import static com.neverbounce.api.internal.HttpClient.API_KEY;
import static com.neverbounce.api.internal.HttpClient.HTTP_METHOD_GET;
import static com.neverbounce.api.internal.HttpClient.HTTP_METHOD_POST;
import static com.neverbounce.api.internal.HttpClient.JSON_FACTORY;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
class DefaultHttpRequestInitializer implements HttpRequestInitializer {

  private final String apiKey;

  public DefaultHttpRequestInitializer(String apiKey) {
    this.apiKey = apiKey;
  }

  @Override
  public void initialize(HttpRequest httpRequest) throws IOException {
    httpRequest.setParser(JSON_FACTORY.createJsonObjectParser());

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

    // throw new UnsupportedOperationException("Cannot authenticate request for unimplemented HTTP method " + requestMethod);
  }

}
