package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;
import static com.neverbounce.api.model.InputLocation.SUPPLIED;

import com.neverbounce.api.internal.HttpClient;
import java.util.ArrayList;
import java.util.List;

/**
 * Supplying the data directly gives you the option to dynamically create email lists on the fly
 * rather than having to write to a file. input will accept an array of objects or arrays that
 * contain the email, as well as any ancillary data you wish to associate with the email
 * (e.g. user IDs, names, contact information).
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-create">Jobs Create</a>
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
