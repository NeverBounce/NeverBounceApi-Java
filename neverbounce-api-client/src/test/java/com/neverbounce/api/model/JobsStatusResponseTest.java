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
    assertEquals(185137, response.getId());
    assertEquals("NBUser_1054_58f2b406006f1", response.getFilename());
    assertEquals(new Date(117, 3, 15, 20, 0, 6), response.getCreated());
    assertEquals(new Date(117, 3, 15, 20, 0, 21), response.getStarted());
    assertEquals(new Date(117, 3, 15, 21, 52, 46), response.getFinished());
    assertEquals(24606, response.getTotalRecords());
    assertEquals(24606, response.getTotalBillable());
    assertEquals(24606, response.getTotalProcessed());
    assertEquals(18227, response.getTotalValid());
    assertEquals(1305, response.getTotalInvalid());
    assertEquals(4342, response.getTotalCatchall());
    assertEquals(16, response.getTotalDisposable());
    assertEquals(716, response.getTotalUnknown());
    assertEquals(0, response.getTotalDuplicates());
    assertEquals(0, response.getTotalBadSyntax());
    assertEquals(100, response.getPercentComplete());
    assertEquals(COMPLETE, response.getJobStatus());
  }

}
