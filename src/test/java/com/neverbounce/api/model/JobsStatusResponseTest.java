package com.neverbounce.api.model;

import static com.neverbounce.api.model.JobStatus.COMPLETE;
import static org.junit.Assert.*;

import java.util.Date;

/**
 * Created by lcsontos on 7/28/17.
 */
public class JobsStatusResponseTest extends AbstractResponseTest<JobsStatusResponse> {

  @Override
  protected Class<JobsStatusResponse> getResponseClass() {
    return JobsStatusResponse.class;
  }

  @Override
  protected String getResponseResourceName() {
    return "job_status_response.json";
  }

  @Override
  protected void assertResponse(JobsStatusResponse response) {
    assertNotNull(response);
    assertEquals(277461, response.getId());
    assertEquals("Created from Array.csv", response.getFilename());
    assertEquals(new Date(117, 6, 25, 14, 52, 27), response.getCreatedAt());
    assertEquals(new Date(117, 6, 25, 14, 52, 40), response.getStartedAt());
    assertEquals(new Date(117, 6, 25, 14, 53, 06), response.getFinishedAt());
    assertEquals(2, response.getTotal().getRecords());
    assertEquals(2, response.getTotal().getBillable());
    assertEquals(2, response.getTotal().getProcessed());
    assertEquals(0, response.getTotal().getValid());
    assertEquals(2, response.getTotal().getInvalid());
    assertEquals(0, response.getTotal().getCatchall());
    assertEquals(0, response.getTotal().getDisposable());
    assertEquals(0, response.getTotal().getUnknown());
    assertEquals(0, response.getTotal().getDuplicates());
    assertEquals(0, response.getTotal().getBadSyntax());
    assertEquals(100, response.getPercentComplete());
    assertEquals(COMPLETE, response.getJobStatus());
  }

}
