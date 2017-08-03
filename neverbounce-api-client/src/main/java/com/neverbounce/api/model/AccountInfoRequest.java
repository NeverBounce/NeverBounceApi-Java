package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;

/**
 * Account endpoints allow to programmatically check your account's balance and how many jobs are
 * currently running on your account.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#account-info">Account</a>
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
