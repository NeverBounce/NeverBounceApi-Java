package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * The jobs create endpoint allows you create verify multiple emails together, the same way you
 * would verify lists in the dashboard.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-create">Jobs Create</a>
 */
public abstract class JobsCreateRequest<T> extends AbstractRequest<JobsCreateResponse> {

  public static final String PATH = "jobs/create";

  @Key("input_location")
  private final InputLocation inputLocation;

  @Key
  private final T input;

  @Key("auto_parse")
  private final int autoParse;

  @Key("auto_start")
  private final int autoStart;

  @Key("run_sample")
  private final Integer runSample;

  @Key
  private final String filename;

  JobsCreateRequest(HttpClient httpClient,
      InputLocation inputLocation, T input, int autoParse, int autoStart, Integer runSample,
      String filename) {

    super(httpClient);
    this.inputLocation = inputLocation;
    this.input = input;
    this.autoParse = autoParse;
    this.autoStart = autoStart;
    this.runSample = runSample;
    this.filename = filename;
  }

  @Override
  public JobsCreateResponse execute() {
    return getHttpClient().postForObject(PATH, this, JobsCreateResponse.class);
  }

  public abstract static class Builder<T, R extends JobsCreateRequest<T>>
      extends AbstractRequestBuilder<R> {

    protected final InputLocation inputLocation;

    protected T input;
    protected Boolean autoParse;
    protected Boolean autoStart;
    protected Boolean runSample;
    protected String filename;

    public Builder(HttpClient httpClient, InputLocation inputLocation) {
      super(httpClient);
      this.inputLocation = inputLocation;
    }

    public Builder<T, R> withAutoParse(boolean autoParse) {
      this.autoParse = autoParse;
      return this;
    }

    public Builder<T, R> withAutoStart(boolean autoStart) {
      this.autoStart = autoStart;
      return this;
    }

    public Builder<T, R> withRunSample(Boolean runSample) {
      this.runSample = runSample;
      return this;
    }

    public Builder<T, R> withFilename(String filename) {
      this.filename = filename;
      return this;
    }

    @Override
    protected void validate() {
      Preconditions.checkState(input != null, "input must not be null");
      Preconditions.checkState(autoParse != null, "auto_parse must not be null");
      Preconditions.checkState(autoStart != null, "auto_start must not be null");
    }

  }

}
