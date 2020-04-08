package com.neverbounce.api.model;

import com.google.api.client.util.Value;

/**
 * https://developers.neverbounce.com/v4.0/reference#section-flags
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#section-flags">Flags</a>
 */
public enum Flag {

  /**
   * Domain has DNS.
   */
  HAS_DNS(""),

  /**
   * Domain has DNS MX.
   */
  HAS_DNS_MX(""),
    
  /**
   * The input given doesn't appear to be an email.
   */
  BAD_SYNTAX("The input given doesn't appear to be an email."),

  /**
   * This email is registered on a free-mail host. (e.g: yahoo.com, hotmail.com)
   */
  FREE_EMAIL_HOST("This email is registered on a free-mail host. (e.g: yahoo.com, hotmail.com)"),

  /**
   * SMTP connectable.
   */
  SMTP_CONNECTABLE(""),

  /**
   * Role Account.
   */
  ROLE_ACCOUNT(""),
  
  /**
   * Disposable Email.
   */
  DISPOSABLE_EMAIL("The input given is a disposable email"),
  
  /**
   * Government Host.
   */
  GOVERNMENT_HOST("The input given is a government email"),
  
  /**
   * Acedemic Host.
   */
  ACEDEMIC_HOST("The input given is a acedemic email"),
  
  /**
   * Military Host.
   */
  MILITARY_HOST("The input given is a military email"),
  
  /**
   * International Host.
   */
  INTERNATIONAL_HOST(""),
  
  /**
   * Squatter Host.
   */
  SQUATTER_HOST(""),
  
  /**
   * Spelling Mistake.
   */
  SPELLING_MISTAKE("The input was misspelled"),
  
  /**
   * Bad DNS.
   */
  BAD_DNS(""),
  
  /**
   * TEMPORARY DNS ERROR.
   */
  TEMPORARY_DNS_ERROR(""),
  
  /**
   * Connect Fails.
   */
  CONNECT_FAILS(""),
  
  /**
   * Accept All.
   */
  ACCEPT_ALL(""),
  
  /**
   * Contains Alias.
   */
  CONTAINS_ALIAS(""),
  
  /**
   * Contains Subdomain.
   */
  CONTAINS_SUBDOMAIN(""),
  
  /**
   * Spamtrap Network.
   */
  SPAMTRAP_NETWORK(""),
  
  /**
   * Contains Profanity in email.
   */
  PROFANITY(""),

  /**
   * Historical data points were used to determine the result.
   */
  HISTORICAL_RESPONSE(""),

  /**
   * Historical verifications were used to determine the result.
   */
  HISTORICAL_RESPONSE_NEVERBOUNCE(""),

  /**
   * Historical CE data points were used to determine the result.
   */
  HISTORICAL_RESPONSE_COMMUNITY_EDITION(""),

  USER_RULE_RESPONSE(""),

  MAILBOX_FULL(""),

  MAILBOX_EXPIRED("");


  private String description;

  Flag(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
