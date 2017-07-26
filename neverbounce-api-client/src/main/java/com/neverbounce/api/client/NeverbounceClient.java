package com.neverbounce.api.client;

import com.neverbounce.api.model.AccountInfoRequest;

/**
 * Entry point to NeverbounceClient's API.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface NeverbounceClient {

  AccountInfoRequest createAccountInfoRequest();

}