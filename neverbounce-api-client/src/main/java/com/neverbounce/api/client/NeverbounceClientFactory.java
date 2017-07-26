package com.neverbounce.api.client;

import com.neverbounce.api.internal.HttpClient;
import com.neverbounce.api.internal.HttpClientImpl;
import com.neverbounce.api.internal.NeverbounceClientImpl;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class NeverbounceClientFactory {

  private NeverbounceClientFactory() {
  }

  public static NeverbounceClient create(String apiKey) {
    HttpClient httpClient = new HttpClientImpl(apiKey);
    return new NeverbounceClientImpl(httpClient);
  }

}
