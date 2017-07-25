package com.neverbounce.api.client.exception;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class NeverbounceIOException extends RuntimeException {

  public NeverbounceIOException(String message) {
    super(message);
  }

  public NeverbounceIOException(String message, Throwable cause) {
    super(message, cause);
  }

  public NeverbounceIOException(Throwable cause) {
    super(cause);
  }

}
