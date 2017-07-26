package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class AccountInfoRequest extends AbstractRequest<AccountInfoResponse> {

  public static final String PATH = "account/info";

  public AccountInfoRequest(HttpClient httpClient) {
    super(httpClient);
  }

  @Override
  public AccountInfoResponse execute() {
    return getHttpClient().getForObject(PATH, AccountInfoResponse.class);
  }

}
