package com.neverbounce.api.model;

import com.neverbounce.api.internal.HttpClient;
import com.neverbounce.api.model.AbstractJobsRequest.Builder;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-delete
 *
 * @author Laszlo Csontos
 * @since 4.0.0
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
