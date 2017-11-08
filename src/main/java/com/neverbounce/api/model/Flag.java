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
  @Value("has_dns")
  HAS_DNS(""),

  /**
   * Domain has DNS MX.
   */
  @Value("has_dns_mx")
  HAS_DNS_MX(""),
    
  /**
   * The input given doesn't appear to be an email.
   */
  @Value("bad_syntax")
  BAD_SYNTAX("The input given doesn't appear to be an email."),

  /**
   * This email is registered on a free-mail host. (e.g: yahoo.com, hotmail.com)
   */
  @Value("free_email_host")
  FREE_EMAIL_HOST("This email is registered on a free-mail host. (e.g: yahoo.com, hotmail.com)"),

  /**
   * SMTP connectable.
   */
  @Value("smtp_connectable")
  SMTP_CONNECTABLE(""),

  /**
   * Role Account.
   */
  @Value("role_account")
  ROLE_ACCOUNT(""),
  
  /**
   * Disposable Email.
   */
  @Value("disposable_email")
  DISPOSABLE_EMAIL("The input given is a disposable email"),
  
  /**
   * Government Host.
   */
  @Value("government_host")
  GOVERNMENT_HOST("The input given is a government email"),
  
  /**
   * Acedemic Host.
   */
  @Value("acedemic_host")
  ACEDEMIC_HOST("The input given is a acedemic email"),
  
  /**
   * Military Host.
   */
  @Value("military_host")
  MILITARY_HOST("The input given is a military email"),
  
  /**
   * International Host.
   */
  @Value("international_host")
  INTERNATIONAL_HOST(""),
  
  /**
   * Squatter Host.
   */
  @Value("squatter_host")
  SQUATTER_HOST(""),
  
  /**
   * Spelling Mistake.
   */
  @Value("spelling_mistake")
  SPELLING_MISTAKE("The input was misspelled"),
  
  /**
   * Bad DNS.
   */
  @Value("bad_dns")
  BAD_DNS(""),
  
  /**
   * TEMPORARY DNS ERROR.
   */
  @Value("temporary_dns_error")
  TEMPORARY_DNS_ERROR(""),
  
  /**
   * Connect Fails.
   */
  @Value("connect_fails")
  CONNECT_FAILS(""),
  
  /**
   * Accept All.
   */
  @Value("accepts_all")
  ACCEPT_ALL(""),
  
  /**
   * Contains Alias.
   */
  @Value("contains_alias")
  CONTAINS_ALIAS(""),
  
  /**
   * Contains Subdomain.
   */
  @Value("contains_subdomain")
  CONTAINS_SUBDOMAIN(""),
  
  /**
   * Spamtrap Network.
   */
  @Value("spamtrap_network")
  SPAMTRAP_NETWORK("");

  private String description;

  Flag(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
