package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-create
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsCreateResponse extends GenericResponse {

  @Key("job_id")
  private long jobId;

  public long getJobId() {
    return jobId;
  }

}
