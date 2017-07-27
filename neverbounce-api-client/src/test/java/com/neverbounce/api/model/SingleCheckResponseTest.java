package com.neverbounce.api.model;

import static com.neverbounce.api.model.Flag.HAS_DNS;
import static com.neverbounce.api.model.Flag.HAS_DNS_MX;
import static com.neverbounce.api.model.Status.SUCCESS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lcsontos on 7/27/17.
 */
public class SingleCheckResponseTest extends AbstractResponseTest<SingleCheckResponse> {

  @Override
  protected Class<SingleCheckResponse> getResponseClass() {
    return SingleCheckResponse.class;
  }

  @Override
  protected String getResponseResourceName() {
    return "single_check_response.json";
  }

  @Override
  protected void assertResponse(SingleCheckResponse response) {
    assertNotNull(response);
    assertEquals(SUCCESS, response.getStatus());
    assertTrue(response.getFlags().contains(HAS_DNS));
    assertTrue(response.getFlags().contains(HAS_DNS_MX));
    assertEquals("", response.getSuggestedCorrection());
    assertEquals("", response.getRetryToken());
    assertEquals(499, response.getExecutionTime());
  }

}
