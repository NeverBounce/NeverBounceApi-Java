package com.neverbounce.api.model;

import com.google.api.client.util.Value;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public enum InputLocation {

  /**
   * Using a remote URL allows you to host the file and provide us with a direct link to it. The
   * file should be a list of emails separated by line breaks or a standard CSV file. We support
   * most common file transfer protocols and they're authentication mechanisms. When using a URL
   * that requires authentication be sure to pass the username and password in the URI string.
   */
  @Value("remote_url")
  REMOTE_URL,

  /**
   * Supplying the data directly gives you the option to dynamically create email lists on the fly
   * rather than having to write to a file. input will accept an array of objects or arrays that
   * contain the email, as well as any ancillary data you wish to associate with the email
   * (e.g. user IDs, names, contact information).
   */
  @Value("supplied")
  SUPPLIED;

}
