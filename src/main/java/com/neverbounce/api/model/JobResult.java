package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobResult {

  @Key("data")
  private EmailData emailData;

  @Key
  private SingleCheckResponse verification;

  public EmailData getEmailData() {
    return emailData;
  }

  public void setEmailData(EmailData emailData) {
    this.emailData = emailData;
  }

  public SingleCheckResponse getVerification() {
    return verification;
  }

  public void setVerification(SingleCheckResponse verification) {
    this.verification = verification;
  }

}
