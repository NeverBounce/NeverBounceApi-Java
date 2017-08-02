package com.neverbounce.api.model;

import static com.neverbounce.api.model.Flag.HAS_DNS;
import static com.neverbounce.api.model.Flag.HAS_DNS_MX;
import static com.neverbounce.api.model.Flag.SMTP_CONNECTABLE;
import static com.neverbounce.api.model.Result.INVALID;
import static com.neverbounce.api.model.Status.SUCCESS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

/**
 * Created by lcsontos on 7/27/17.
 */
public class JobsResultsResponseTest extends AbstractResponseTest<JobsResultsResponse> {

  @Override
  protected Class<JobsResultsResponse> getResponseClass() {
    return JobsResultsResponse.class;
  }

  @Override
  protected String getResponseResourceName() {
    return "job_results_response.json";
  }

  @Override
  protected void assertResponse(JobsResultsResponse response) {
    assertNotNull(response);
    assertEquals(3, response.getTotalResults());
    assertEquals(1, response.getTotalPages());

    // Query
    assertEquals(251319, response.getQuery().getJobId());
    assertEquals(1, response.getQuery().getValids());
    assertEquals(1, response.getQuery().getInvalids());
    assertEquals(1, response.getQuery().getDisposables());
    assertEquals(1, response.getQuery().getCatchalls());
    assertEquals(1, response.getQuery().getUnknowns());
    assertEquals(0, response.getQuery().getPage());
    assertEquals(10, response.getQuery().getItemsPerPage());

    // Results
    List<JobResult> results = response.getResults();
    assertNotNull(results);
    assertFalse(results.isEmpty());

    // First result
    JobResult result = results.get(0);
    assertNotNull(result);

    // Email Data
    EmailData data = result.getEmailData();
    assertNotNull(data);
    assertEquals("invalid@neverbounce.com", data.getEmail());
    assertEquals("12346", data.getId());
    assertEquals("Bob McInvalid", data.getName());
    assertEquals("1234", data.get("customerId"));

    // Verification
    SingleCheckResponse verification = result.getVerification();
    assertNotNull(verification);
    assertEquals(INVALID, verification.getResult());
    assertTrue(verification.getFlags().contains(HAS_DNS));
    assertTrue(verification.getFlags().contains(HAS_DNS_MX));
    assertTrue(verification.getFlags().contains(SMTP_CONNECTABLE));
    assertEquals("", verification.getSuggestedCorrection());

    // Address info
    SingleCheckResponse.AddressInfo addressInfo = verification.getAddressInfo();
    assertNotNull(addressInfo);
    assertEquals("invalid@neverbounce.com", addressInfo.getOriginalEmail());
    assertEquals("invalid@neverbounce.com", addressInfo.getNormalizedEmail());
    assertEquals("invalid", addressInfo.getAddr());
    assertEquals("", addressInfo.getAlias());
    assertEquals("neverbounce.com", addressInfo.getHost());
    assertEquals("neverbounce.com", addressInfo.getFqdn());
    assertEquals("neverbounce", addressInfo.getDomain());
    assertEquals("", addressInfo.getSubdomain());
    assertEquals("com", addressInfo.getTld());
  }

}
