package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * Single verification allows you verify individual emails and gather additional information
 * pertaining to the email.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#single-check">Single Check</a>
 */
public class SingleCheckRequest extends AbstractRequest<SingleCheckResponse> {

  public static final String PATH = "single/check";

  @Key
  private final String email;

  @Key("address_info")
  private final Integer addressInfo;

  @Key("credits_info")
  private final Integer creditsInfo;

  @Key
  private final Integer timeout;

  SingleCheckRequest(
      HttpClient httpClient, String email, Integer addressInfo, Integer creditsInfo,
      Integer timeout) {

    super(httpClient);
    this.email = email;
    this.addressInfo = addressInfo;
    this.creditsInfo = creditsInfo;
    this.timeout = timeout;
  }

  @Override
  public SingleCheckResponse execute() {
    return getHttpClient().getForObject(PATH, this, SingleCheckResponse.class);
  }

  public static class Builder extends AbstractRequestBuilder<SingleCheckRequest> {

    private String email;
    private Integer addressInfo;
    private Integer creditsInfo;
    private Integer timeout;

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    public Builder withEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder withAddressInfo(boolean addressInfo) {
      this.addressInfo = addressInfo ? 1 : 0;
      return this;
    }

    public Builder withCreditsInfo(boolean creditsInfo) {
      this.creditsInfo = creditsInfo ? 1 : 0;
      return this;
    }

    public Builder withTimeout(int timeout) {
      this.timeout = timeout;
      return this;
    }

    @Override
    protected SingleCheckRequest doBuild() {
      return new SingleCheckRequest(httpClient, email, addressInfo, creditsInfo, timeout);
    }

    @Override
    protected void validate() {
      Preconditions.checkState(email != null, "email must not be null");
    }

  }

}
