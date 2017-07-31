package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsStatusRequest extends AbstractJobsRequest<JobsStatusResponse> {

  public static final String PATH = "jobs/status";

  public JobsStatusRequest(HttpClient httpClient, long jobId) {
    super(httpClient, jobId);
  }

  @Override
  public JobsStatusResponse execute() {
    return getHttpClient().getForObject(PATH, this, JobsStatusResponse.class);
  }

  public static class Builder extends AbstractJobsRequest.Builder<JobsStatusRequest, Builder> {

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    @Override
    protected JobsStatusRequest doBuild() {
      return new JobsStatusRequest(httpClient, jobId);
    }

  }

}
