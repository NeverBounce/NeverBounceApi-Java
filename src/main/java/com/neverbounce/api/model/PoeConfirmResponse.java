package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * @author David Borrowman
 * @since 4.0.1
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#poe-confirm">POE Confirm</a>
 */

public class PoeConfirmResponse extends GenericResponse {
  @Key("token_confirmed")
  private Boolean tokenConfirmed;
  
  public Boolean getTokenConfirmed() {
    return this.tokenConfirmed;
  }

  public void setTokenConfirmed(Boolean tokenConfirmed) {
    this.tokenConfirmed = tokenConfirmed;
  }
}
