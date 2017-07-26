package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
class BaseResponse implements Response {

  @Key("execution_time")
  private long executionTime;

  @Key
  private Status status;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public long getExecutionTime() {
    return executionTime;
  }

  public void setExecutionTime(long executionTime) {
    this.executionTime = executionTime;
  }

}
