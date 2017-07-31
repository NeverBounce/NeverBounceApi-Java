package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;
import static com.neverbounce.api.model.InputLocation.REMOTE_URL;

import com.neverbounce.api.internal.HttpClient;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-create
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsCreateWithRemoteUrlRequest extends JobsCreateRequest<String> {

  JobsCreateWithRemoteUrlRequest(HttpClient httpClient,
      InputLocation inputLocation, String input, int autoParse, int autoStart,
      Integer runSample, String filename) {

    super(httpClient, inputLocation, input, autoParse, autoStart, runSample, filename);
  }

  public static class Builder
      extends JobsCreateRequest.Builder<String, JobsCreateWithRemoteUrlRequest> {

    public Builder(HttpClient httpClient) {
      super(httpClient, REMOTE_URL);
    }

    public Builder withInput(String input) {
      this.input = input;
      return this;
    }

    @Override
    public JobsCreateWithRemoteUrlRequest build() {
      return super.build();
    }

    @Override
    protected JobsCreateWithRemoteUrlRequest doBuild() {
      return new JobsCreateWithRemoteUrlRequest(
          httpClient,
          inputLocation,
          input,
          toInteger(autoParse),
          toInteger(autoStart),
          toInteger(runSample),
          filename
      );
    }

  }

}
