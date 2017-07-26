package com.neverbounce.api.model;

import static com.neverbounce.api.internal.HttpClient.JSON_FACTORY;
import static com.neverbounce.api.model.Status.SUCCESS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.api.client.json.JsonParser;
import com.neverbounce.api.internal.IoUtils;
import org.junit.Test;

/**
 * Created by lcsontos on 7/26/17.
 */
public class AccountInfoResponseTest {

  @Test
  public void testDeserialize() throws Exception {
    String content = IoUtils.getResourceAsString("account_info_response.json");
    JsonParser jsonParser = JSON_FACTORY.createJsonParser(content);
    AccountInfoResponse accountInfoResponse = jsonParser.parse(AccountInfoResponse.class);

    assertNotNull(accountInfoResponse);
    assertEquals("default", accountInfoResponse.getBillingType());
    assertEquals(53479, accountInfoResponse.getCredits());
    assertEquals(0, accountInfoResponse.getFreeApiCredits());
    assertEquals(376, accountInfoResponse.getMonthlyApiUsage());
    assertEquals(0, accountInfoResponse.getMonthlyDashboardUsage());
    assertEquals(286, accountInfoResponse.getJobsCompleted());
    assertEquals(0, accountInfoResponse.getJobsUnderReview());
    assertEquals(0, accountInfoResponse.getJobsQueued());
    assertEquals(0, accountInfoResponse.getJobsProcessing());
    assertEquals(SUCCESS, accountInfoResponse.getStatus());
    assertEquals(1419, accountInfoResponse.getExecutionTime());
  }

}
