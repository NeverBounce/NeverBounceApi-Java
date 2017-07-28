package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;

import com.google.api.client.util.Key;
import com.neverbounce.api.internal.HttpClient;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-start
 *
 * @author Laszlo Csontos
 * @since 4.0.0
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
