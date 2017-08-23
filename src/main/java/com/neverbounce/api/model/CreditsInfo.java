package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#account-info">Account</a>
 */
public class CreditsInfo {

  @Key("paid_credits_used")
  private int paidCreditsUsed;

  @Key("free_credits_used")
  private int freeCreditsUsed;

  @Key("paid_credits_remaining")
  private int paidCreditsRemaining;

  @Key("free_credits_remaining")
  private int freeCreditsRemaining;

  public int getPaidCreditsUsed() {
    return paidCreditsUsed;
  }

  public void setPaidCreditsUsed(int paidCreditsUsed) {
    this.paidCreditsUsed = paidCreditsUsed;
  }

  public int getFreeCreditsUsed() {
    return freeCreditsUsed;
  }

  public void setFreeCreditsUsed(int freeCreditsUsed) {
    this.freeCreditsUsed = freeCreditsUsed;
  }

  public int getPaidCreditsRemaining() {
    return paidCreditsRemaining;
  }

  public void setPaidCreditsRemaining(int paidCreditsRemaining) {
    this.paidCreditsRemaining = paidCreditsRemaining;
  }

  public int getFreeCreditsRemaining() {
    return freeCreditsRemaining;
  }

  public void setFreeCreditsRemaining(int freeCreditsRemaining) {
    this.freeCreditsRemaining = freeCreditsRemaining;
  }

}
