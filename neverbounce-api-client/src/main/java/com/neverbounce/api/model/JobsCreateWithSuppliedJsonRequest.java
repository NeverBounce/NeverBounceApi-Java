package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;
import static com.neverbounce.api.model.InputLocation.SUPPLIED;

import com.neverbounce.api.internal.HttpClient;
import java.util.ArrayList;
import java.util.List;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-create
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsCreateWithSuppliedJsonRequest extends JobsCreateRequest<List<String[]>> {

  public JobsCreateWithSuppliedJsonRequest(HttpClient httpClient,
      InputLocation inputLocation, List<String[]> input, int autoParse, int autoStart,
      Integer runSample, String filename) {

    super(httpClient, inputLocation, input, autoParse, autoStart, runSample, filename);
  }

  public static class Builder
      extends JobsCreateRequest.Builder<List<String[]>, JobsCreateWithSuppliedJsonRequest> {

    public Builder(HttpClient httpClient) {
      super(httpClient, SUPPLIED);
      input = new ArrayList<String[]>();
    }

    public Builder addInput(String email, String name) {
      input.add(new String[] { email, name });
      return this;
    }

    @Override
    public JobsCreateWithSuppliedJsonRequest build() {
      return super.build();
    }

    @Override
    protected JobsCreateWithSuppliedJsonRequest doBuild() {
      return new JobsCreateWithSuppliedJsonRequest(
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
