package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;

import com.google.api.client.util.Key;
import com.neverbounce.api.internal.HttpClient;

/**
 * This endpoint allows you to start a job created or parsed with auto_start disabled. Once the list
 * has been started the credits will be deducted and the process cannot be stopped or restarted.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-start">Jobs Start</a>
 */
public class JobsStartRequest extends AbstractJobsRequest<JobsStartResponse> {

  public static final String PATH = "jobs/start";

  @Key("run_sample")
  private final Integer runSample;

  JobsStartRequest(HttpClient httpClient, long jobId, Integer runSample) {
    super(httpClient, jobId);
    this.runSample = runSample;
  }

  @Override
  public JobsStartResponse execute() {
    return getHttpClient().postForObject(PATH, this, JobsStartResponse.class);
  }

  public static class Builder extends AbstractJobsRequest.Builder<JobsStartRequest, Builder> {

    private Boolean runSample;

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    public Builder withRunSample(Boolean runSample) {
      this.runSample = runSample;
      return this;
    }

    @Override
    protected JobsStartRequest doBuild() {
      return new JobsStartRequest(httpClient, jobId, toInteger(runSample));
    }

  }

}
