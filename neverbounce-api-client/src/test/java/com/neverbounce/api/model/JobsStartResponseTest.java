package com.neverbounce.api.model;

import static org.junit.Assert.*;

/**
 * Created by lcsontos on 7/28/17.
 */
public class JobsStartResponseTest extends AbstractResponseTest<JobsStartResponse> {

  @Override
  protected Class<JobsStartResponse> getResponseClass() {
    return JobsStartResponse.class;
  }

  @Override
  protected String getResponseResourceName() {
    return "job_start_response.json";
  }

  @Override
  protected void assertResponse(JobsStartResponse response) {
    assertNotNull(response);
    assertEquals("NB-PQ-59246392E9E5D", response.getQueueId());
  }

}
