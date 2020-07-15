package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

import java.util.Map;

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

  @Key("request_meta_data[leverage_historical_data]")
  private final Integer historicalData;

  @Key("allow_manual_review")
  private final Integer allowManualReview;

  @Key("callback_url")
  private final String callbackUrl;

  @Key("callback_headers")
  private final Map<String, String> callbackHeaders;

  JobsCreateRequest(HttpClient httpClient,
      InputLocation inputLocation, T input, int autoParse, int autoStart, Integer runSample,
      String filename, Integer historicalData, Integer allowManualReview, String callbackUrl, Map<String, String> callbackHeaders) {

    super(httpClient);
    this.inputLocation = inputLocation;
    this.input = input;
    this.autoParse = autoParse;
    this.autoStart = autoStart;
    this.runSample = runSample;
    this.filename = filename;
    this.historicalData = historicalData;
    this.allowManualReview = allowManualReview;
    this.callbackUrl = callbackUrl;
    this.callbackHeaders = callbackHeaders;
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
    protected Integer historicalData;
    protected Boolean allowManualReview;
    protected String callbackUrl;
    protected Map<String, String> callbackHeaders;

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

    public Builder<T, R> withHistoricalData(boolean historicalData) {
      this.historicalData = historicalData ? 1 : 0;
      return this;
    }

    public Builder<T, R> withAllowManualReview(boolean allowManualReview) {
      this.allowManualReview = allowManualReview;
      return this;
    }

    public Builder<T, R> withCallbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }

    public Builder<T, R> withCallbackHeaders(Map<String, String> callbackHeaders) {
      this.callbackHeaders = callbackHeaders;
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
