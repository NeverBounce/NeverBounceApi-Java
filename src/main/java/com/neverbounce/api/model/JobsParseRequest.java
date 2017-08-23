package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * This endpoint allows you to parse a job created with {@code auto_parse} disabled. You cannot
 * reparse a list once it's been parsed.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-parse">Jobs Parse</a>
 */
public class JobsParseRequest extends AbstractJobsRequest<JobsParseResponse> {

  public static final String PATH = "jobs/parse";

  @Key("auto_start")
  private final Integer autoStart;

  JobsParseRequest(HttpClient httpClient, long jobId, Integer autoStart) {
    super(httpClient, jobId);
    this.autoStart = autoStart;
  }

  @Override
  public JobsParseResponse execute() {
    return getHttpClient().postForObject(PATH, this, JobsParseResponse.class);
  }

  public static class Builder extends AbstractJobsRequest.Builder<JobsParseRequest, Builder> {

    private Boolean autoStart;

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    public Builder withAutoStart(Boolean autoStart) {
      this.autoStart = autoStart;
      return this;
    }

    @Override
    protected JobsParseRequest doBuild() {
      return new JobsParseRequest(httpClient, jobId, toInteger(autoStart));
    }

    @Override
    protected void validate() {
      super.validate();
      Preconditions.checkState(autoStart != null, "auto_start must not be null");
    }
  }

}
