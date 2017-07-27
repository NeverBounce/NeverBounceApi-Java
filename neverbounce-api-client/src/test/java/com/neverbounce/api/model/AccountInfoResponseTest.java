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
    assertEquals("default", response.getBillingType());
    assertEquals(53479, response.getCredits());
    assertEquals(0, response.getFreeApiCredits());
    assertEquals(376, response.getMonthlyApiUsage());
    assertEquals(0, response.getMonthlyDashboardUsage());
    assertEquals(286, response.getJobsCompleted());
    assertEquals(0, response.getJobsUnderReview());
    assertEquals(0, response.getJobsQueued());
    assertEquals(0, response.getJobsProcessing());
    assertEquals(SUCCESS, response.getStatus());
    assertEquals(1419, response.getExecutionTime());
  }

}
