package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;

/**
 * Job status will indicate what stage the job is currently in. This will be the primary property
 * you'll want to check to determine what can be done with the job.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-status">Jobs Status</a>
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
