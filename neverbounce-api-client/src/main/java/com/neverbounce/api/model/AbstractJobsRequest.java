package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
abstract class AbstractJobsRequest<R extends Response> extends AbstractRequest<R> {

  @Key("job_id")
  private final long jobId;

  AbstractJobsRequest(HttpClient httpClient, long jobId) {
    super(httpClient);
    this.jobId = jobId;
  }

  public abstract static class Builder<R extends AbstractJobsRequest>
      extends AbstractRequestBuilder<R> {

    protected Long jobId;

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    public Builder<R> withJobId(long jobId) {
      this.jobId = jobId;
      return this;
    }

    @Override
    protected void validate() {
      Preconditions.checkState(jobId != null, "job_id must not be null");
    }

  }

}
