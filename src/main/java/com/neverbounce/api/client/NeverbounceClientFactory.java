package com.neverbounce.api.client;

import com.neverbounce.api.internal.HttpClient;
import com.neverbounce.api.internal.HttpClientImpl;
import com.neverbounce.api.internal.NeverbounceClientImpl;

/**
 * Used to instantiate {@link NeverbounceClient}.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class NeverbounceClientFactory {

  private NeverbounceClientFactory() {
  }

  /**
   * Create a new instance of {@link NeverbounceClient}.
   * @param apiKey API key.
   * @return a new instance of {@link NeverbounceClient}
   */
  public static NeverbounceClient create(String apiKey) {
    HttpClient httpClient = new HttpClientImpl(apiKey);
    return new NeverbounceClientImpl(httpClient);
  }

}
