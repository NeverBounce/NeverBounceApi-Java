package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
class GenericResponse implements Response {

  @Key("execution_time")
  private long executionTime;

  @Key
  private Status status;

  @Key
  private String message;

  @Override
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }

  public void setExecutionTime(long executionTime) {
    this.executionTime = executionTime;
  }

  @Override
  public String getMessage() {
    return message;
  }

}
