package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
abstract class AbstractRequestBuilder<R extends Request> {

  final HttpClient httpClient;

  AbstractRequestBuilder(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public R build() {
    validate();
    return doBuild();
  }

  protected abstract void validate();

  protected abstract R doBuild();

}
