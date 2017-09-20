package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * Allows you to confirm a token recieved from the neverbounce POE API
 *
 * @author David Borrowman
 * @since 4.0.1
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#poe-confirm">Poe Confirm</a>
 */
public class PoeConfirmRequest extends AbstractRequest<PoeConfirmResponse> {
  public static final String PATH = "poe/confirm";
  @Key
  private final String email;
  
  @Key
  private final String result;

  @Key("transaction_id")
  private final String transactionId;

  @Key("confirmation_token")
  private final String confirmationToken;
  
  /**
   * Allows you to confirm that the token received by poe/confirm was not a forgery
   *
   * @author David Borrowman
   * @since 4.0.1
   * @param httpClient Client managing the HTTP connection
   * @param email Email address used during poe/check
   * @param result Result returned by poe/check
   * @param transactionId The transactionId that was generated during poe/check
   * @param confirmationToken The confirmation token returned by poe/check
   * @see <a href="https://developers.neverbounce.com/v4.0/reference#poe-confirm">Poe Confirm</a>
   */
  public PoeConfirmRequest(HttpClient httpClient, String email,
      String result, String transactionId, String confirmationToken) {
    super(httpClient);
    this.email = email;
    this.result = result;
    this.transactionId = transactionId;
    this.confirmationToken = confirmationToken;
  }
  
  @Override
  public PoeConfirmResponse execute() {
    return getHttpClient().getForObject(PATH, this, PoeConfirmResponse.class);
  }

  public static class Builder extends AbstractRequestBuilder<PoeConfirmRequest> {
    private String email;
    private String result;
    private String transactionId;
    private String confirmationToken;
    
    public Builder(HttpClient httpClient) {
      super(httpClient);
    }
    
    public Builder withEmail(String email) {
      this.email = email;
      return this;
    }
    
    public Builder withTransactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
    
    public Builder withConfirmationToken(String confirmationToken) {
      this.confirmationToken = confirmationToken;
      return this;
    }
    
    public Builder withResult(String result) {
      this.result = result;
      return this;
    }
    
    @Override
    protected void validate() {
      Preconditions.checkState(email != null, "email must not be null");
    }

    @Override
    protected PoeConfirmRequest doBuild() {
      return new PoeConfirmRequest(httpClient, email, result, transactionId, confirmationToken);
    }
  }
}
