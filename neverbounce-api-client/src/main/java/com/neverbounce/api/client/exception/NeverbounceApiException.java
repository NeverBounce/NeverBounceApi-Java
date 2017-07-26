package com.neverbounce.api.client.exception;

import com.google.api.client.util.Key;
import com.neverbounce.api.model.Response;
import com.neverbounce.api.model.Status;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class NeverbounceApiException extends RuntimeException implements Response {

  @Key("execution_time")
  private long executionTime;

  @Key
  private Status status;

  @Key
  private String message;

  /**
   * Creates a new {@code NeverbounceApiException}.
   */
  public NeverbounceApiException() {
  }

  /**
   * Creates a new {@code NeverbounceApiException} based on the given response.
   *
   * @param response Response
   */
  public NeverbounceApiException(Response response) {
    executionTime = response.getExecutionTime();
    status = response.getStatus();
    message = response.getMessage();
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }

  /**
   * Sets execution time.
   *
   * @param executionTime Execution time
   */
  public void setExecutionTime(long executionTime) {
    this.executionTime = executionTime;
  }

  @Override
  public Status getStatus() {
    return status;
  }

  /**
   * Sets {@link Status}.
   *
   * @param status Status
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String getMessage() {
    return message;
  }

  /**
   * Sets error message.
   *
   * @param message Message
   */
  public void setMessage(String message) {
    this.message = message;
  }

}
