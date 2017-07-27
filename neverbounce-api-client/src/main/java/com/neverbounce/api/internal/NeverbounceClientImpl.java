package com.neverbounce.api.internal;

import com.neverbounce.api.client.NeverbounceClient;
import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.SingleCheckRequest;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class NeverbounceClientImpl implements NeverbounceClient {

  private final HttpClient httpClient;

  public NeverbounceClientImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public AccountInfoRequest createAccountInfoRequest() {
    return new AccountInfoRequest(httpClient);
  }

  @Override
  public SingleCheckRequest.Builder prepareSingleCheckRequest() {
    return new SingleCheckRequest.Builder(httpClient);
  }

}
