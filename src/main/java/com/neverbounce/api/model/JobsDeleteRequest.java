package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;

/**
 * The job and its results cannot be recovered once the job has been deleted. If the results are
 * needed after a job has been deleted you will need to resubmit and reverify the data.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-delete">Jobs Delete</a>
 */
public class JobsDeleteRequest extends AbstractJobsRequest<JobsDeleteResponse> {

  public static final String PATH = "jobs/delete";

  JobsDeleteRequest(HttpClient httpClient, long jobId) {
    super(httpClient, jobId);
  }

  @Override
  public JobsDeleteResponse execute() {
    return getHttpClient().postForObject(PATH, this, JobsDeleteResponse.class);
  }

  public static class Builder extends AbstractJobsRequest.Builder<JobsDeleteRequest, Builder> {

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    @Override
    protected JobsDeleteRequest doBuild() {
      return new JobsDeleteRequest(httpClient, jobId);
    }

  }

}
