package com.neverbounce.api.model;

import com.google.api.client.util.Value;

/**
 * https://developers.neverbounce.com/v4.0/reference#section-flags
 *
 * @author Laszlo Csontos
 * @since 4.0.0
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
    SMTP_CONNECTABLE("");

    private String description;

    Flag(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
