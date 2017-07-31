package com.neverbounce.api.model;

import static com.neverbounce.api.internal.JsonUtils.printJson;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Created by lcsontos on 7/28/17.
 */
public class JobsCreateWithRemoteUrlRequestTest {

  @Test
  public void testBuild() throws Exception {
    JobsCreateWithRemoteUrlRequest jobsCreateWithRemoteUrlRequest =
          new JobsCreateWithRemoteUrlRequest.Builder(null)
              .withInput("test.csv")
              .withAutoParse(true)
              .withAutoStart(true)
              .withFilename("test.csv")
              .build();

    assertNotNull(jobsCreateWithRemoteUrlRequest);

    printJson(jobsCreateWithRemoteUrlRequest);
  }

}
