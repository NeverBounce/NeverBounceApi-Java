package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsStatusRequest extends AbstractRequest<JobsStatusResponse> {

  public static final String PATH = "jobs/status";

  @Key("job_id")
  private final long jobId;

  public JobsStatusRequest(HttpClient httpClient, long jobId) {
    super(httpClient);
    this.jobId = jobId;
  }

  @Override
  public JobsStatusResponse execute() {
    return getHttpClient().getForObject(PATH, this, JobsStatusResponse.class);
  }

  public static class Builder extends AbstractRequestBuilder<JobsStatusRequest> {

    private Long jobId;

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    public JobsStatusRequest.Builder withJobId(long jobId) {
      this.jobId = jobId;
      return this;
    }

    @Override
    protected JobsStatusRequest doBuild() {
      return new JobsStatusRequest(httpClient, jobId);
    }

    @Override
    protected void validate() {
      Preconditions.checkState(jobId != null, "job_id must not be null");
    }

  }

}
