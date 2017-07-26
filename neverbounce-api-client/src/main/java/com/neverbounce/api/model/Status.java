package com.neverbounce.api.model;

import com.google.api.client.util.Value;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public enum Status {

  @Value("success")
  SUCCESS,

  @Value("general_failure")
  GENERAL_FAILURE,

  @Value("auth_failure")
  AUTH_FAILURE,

  @Value("temp_unavail")
  TEMP_UNAVAIL,

  @Value("throttle_triggered")
  THROTTLE_TRIGGERED,

  @Value("bad_referrer")
  BAD_REFERRER;

}
