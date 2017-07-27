package com.neverbounce.api.client;

import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.SingleCheckRequest;

/**
 * Entry point to NeverbounceClient's API.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface NeverbounceClient {

  AccountInfoRequest createAccountInfoRequest();

  SingleCheckRequest.Builder prepareSingleCheckRequest();

}
