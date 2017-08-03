package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;
import static com.neverbounce.api.model.InputLocation.SUPPLIED;

import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class JobsCreateWithSuppliedJsonRequest extends JobsCreateRequest<List<EmailData>> {

  public JobsCreateWithSuppliedJsonRequest(HttpClient httpClient,
      InputLocation inputLocation, List<EmailData> input, int autoParse, int autoStart,
      Integer runSample, String filename) {

    super(httpClient, inputLocation, input, autoParse, autoStart, runSample, filename);
  }

  public static class Builder
      extends JobsCreateRequest.Builder<List<EmailData>, JobsCreateWithSuppliedJsonRequest> {

    public Builder(HttpClient httpClient) {
      super(httpClient, SUPPLIED);
      input = new ArrayList<EmailData>();
    }

    public Builder addInput(Map<String, Object> data) {
      input.add(new EmailData(data));
      return this;
    }

    public Builder addInput(String email) {
      return addInput(null, email, null);
    }

    public Builder addInput(String email, String name) {
      return addInput(null, email, name);
    }

    public Builder addInput(String id, String email, String name) {
      input.add(new EmailData(id, email, name));
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

    @Override
    protected void validate() {
      super.validate();
      for (int index = 0; index < input.size(); index++) {
        EmailData data = input.get(index);
        Preconditions.checkState(
            data.get("email") != null,
            "Field email in input #" + index + " is null."
        );
      }
    }

  }

}
