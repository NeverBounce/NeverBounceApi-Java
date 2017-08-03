package com.neverbounce.api.model;

import static com.neverbounce.api.model.Status.SUCCESS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lcsontos on 7/26/17.
 */
public class AccountInfoResponseTest extends AbstractResponseTest<AccountInfoResponse> {

  @Override
  protected Class<AccountInfoResponse> getResponseClass() {
    return AccountInfoResponse.class;
  }

  @Override
  protected String getResponseResourceName() {
    return "account_info_response.json";
  }

  @Override
  protected void assertResponse(AccountInfoResponse response) {
    assertNotNull(response);
    assertEquals(0, response.getCreditsInfo().getPaidCreditsUsed());
    assertEquals(0, response.getCreditsInfo().getFreeCreditsUsed());
    assertEquals(9950791, response.getCreditsInfo().getPaidCreditsRemaining());
    assertEquals(0, response.getCreditsInfo().getFreeCreditsRemaining());
    assertEquals(409, response.getJobCounts().getCompleted());
    assertEquals(0, response.getJobCounts().getUnderReview());
    assertEquals(0, response.getJobCounts().getQueued());
    assertEquals(0, response.getJobCounts().getProcessing());
    assertEquals(SUCCESS, response.getStatus());
    assertEquals(896, response.getExecutionTime());
  }

}
