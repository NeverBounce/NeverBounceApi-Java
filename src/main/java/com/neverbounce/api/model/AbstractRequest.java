package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
abstract class AbstractRequest<R extends Response> implements Request<R> {

  private final HttpClient httpClient;

  public AbstractRequest(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public HttpClient getHttpClient() {
    return httpClient;
  }

}
