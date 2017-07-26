package com.neverbounce.api.client.exception;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class NeverbounceIoException extends RuntimeException {

  /**
   * Creates a new {@code NeverbounceIoException}.
   *
   * @param message Message
   */
  public NeverbounceIoException(String message) {
    super(message);
  }

  /**
   * Creates a new {@code NeverbounceIoException}.
   *
   * @param message Message
   * @param cause Cause
   */
  public NeverbounceIoException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Creates a new {@code NeverbounceIoException}.
   *
   * @param cause Cause
   */
  public NeverbounceIoException(Throwable cause) {
    super(cause);
  }

}
