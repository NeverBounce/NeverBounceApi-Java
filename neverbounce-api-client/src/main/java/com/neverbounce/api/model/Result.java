package com.neverbounce.api.model;

import static com.neverbounce.api.model.SafeToSend.MAYBE;
import static com.neverbounce.api.model.SafeToSend.NO;
import static com.neverbounce.api.model.SafeToSend.YES;

import com.google.api.client.util.Value;

/**
 * Result codes.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://neverbounce.com/help/getting-started/result-codes/">Result Codes</a>
 */
public enum Result {

  /**
   * A valid email address has been verified as a real email that is currently accepting mail.
   */
  @Value("valid")
  VALID(0, "Verified as real address", YES),

  /**
   * An invalid email address has been verified as a bad recipient address that does not exist or is
   * not accepting mail. Invalid emails will result in a bounce.
   */
  @Value("invalid")
  INVALID(1, "Verified as not valid", NO),

  /**
   * Disposable emails are temporary accounts used to avoid using a real personal account during a
   * sign-up process. Common providers of disposable emails include Mailinator, Guerilla Mail,
   * AirMail, and 10 Minute Mail.
   */
  @Value("disposable")
  DISPOSABLE(2, "A temporary, disposable address", NO),

  /**
   * This is also known as an “accept all”. This is a domain-wide setting where all emails on this
   * domain will be reported as a catch-all. There is no definitive way to determine whether this
   * email is valid or invalid. A catch-all address is commonly used in small businesses to ensure a
   * company receives any email that has been sent to them, regardless of typos. Additionally, these
   * are also found in larger government, medical and educational organizations. Oftentimes these
   * are infact valid emails. However some organizations may utilize this setting as a security
   * feature to prevent unsolicited emails.
   */
  @Value("catchall")
  CATCHALL(3, "A domain-wide setting", MAYBE),

  /**
   * We are unable to definitively determine this email’s status. This email appears to be OK,
   * however the domain and/or server is not responding to our requests. This may be due to an issue
   * with their internal network or expired domain names. Unknown addresses are checked up to 75
   * times before this result code is given.
   */
  @Value("unknown")
  UNKNOWN(4, "The server cannot be reached", NO);

  private int code;
  private String description;
  private SafeToSend safeToSend;

  Result(int code, String description, SafeToSend safeToSend) {
    this.code = code;
    this.description = description;
    this.safeToSend = safeToSend;
  }

  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public SafeToSend isSafeToSend() {
    return safeToSend;
  }

}
