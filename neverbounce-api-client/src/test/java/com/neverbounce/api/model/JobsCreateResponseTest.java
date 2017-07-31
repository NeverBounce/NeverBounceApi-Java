package com.neverbounce.api.model;

import static org.junit.Assert.*;

/**
 * Created by lcsontos on 7/28/17.
 */
public class JobsCreateResponseTest extends AbstractResponseTest<JobsCreateResponse> {

  @Override
  protected Class<JobsCreateResponse> getResponseClass() {
    return JobsCreateResponse.class;
  }

  @Override
  protected String getResponseResourceName() {
    return "job_create_response.json";
  }

  @Override
  protected void assertResponse(JobsCreateResponse response) {
    assertNotNull(response);
    assertEquals(150970, response.getJobId());
  }

}
