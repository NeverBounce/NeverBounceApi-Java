package com.neverbounce.api.model;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
class BaseResponse implements Response {

  // execution_time
  private long executionTime;
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
