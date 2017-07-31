package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-start
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsStartResponse extends GenericResponse {

  @Key("queue_id")
  private String queueId;

  public String getQueueId() {
    return queueId;
  }

  public void setQueueId(String queueId) {
    this.queueId = queueId;
  }

}
