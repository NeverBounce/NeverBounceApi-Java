package com.neverbounce.api.model;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface Response {

  /**
   * Status of the returned request.
   *
   * @return a {@link Status} indicator
   */
  Status getStatus();

  /**
   * Returned execution time in milliseconds.
   *
   * @return execution time in milliseconds
   */
  long getExecutionTime();

  /**
   * Status message if applicable (eg. upon errors).
   *
   * @return status message
   */
  String getMessage();

}
