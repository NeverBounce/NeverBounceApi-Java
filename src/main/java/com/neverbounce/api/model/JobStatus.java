package com.neverbounce.api.model;

import com.google.api.client.util.Value;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public enum JobStatus {

  @Value("under_review")
  UNDER_REVIEW,

  @Value("queued")
  QUEUED,

  @Value("deleted")
  DELETED,

  @Value("failed")
  FAILED,

  @Value("complete")
  COMPLETE,

  @Value("running")
  RUNNING,

  @Value("parsing")
  PARSING,

  @Value("waiting")
  WAITING,

  @Value("uploading")
  UPLOADING;

}
