package com.neverbounce.api.model;

import static com.neverbounce.api.model.Flag.HAS_DNS;
import static com.neverbounce.api.model.Flag.HAS_DNS_MX;
import static com.neverbounce.api.model.Flag.SMTP_CONNECTABLE;
import static com.neverbounce.api.model.Status.SUCCESS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by David Borrowman on 9/15/17.
 */
public class PoeConfirmResponseTest extends AbstractResponseTest<PoeConfirmResponse> {

  @Override
  protected Class<PoeConfirmResponse> getResponseClass() {
    return PoeConfirmResponse.class;
  }

  @Override
  protected String getResponseResourceName() {
    return "poe_confirm_response.json";
  }

  @Override
  protected void assertResponse(PoeConfirmResponse response) {
    assertNotNull(response);
    assertEquals(SUCCESS, response.getStatus());
    assertTrue(response.getTokenConfirmed());
    assertEquals(25, response.getExecutionTime());
  }

}
