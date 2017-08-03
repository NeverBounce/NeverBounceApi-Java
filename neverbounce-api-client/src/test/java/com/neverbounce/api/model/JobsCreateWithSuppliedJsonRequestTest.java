package com.neverbounce.api.model;

import static com.neverbounce.api.internal.JsonUtils.printJson;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by lcsontos on 7/28/17.
 */
public class JobsCreateWithSuppliedJsonRequestTest {

  @Test
  public void testBuild() throws Exception {
    JobsCreateWithSuppliedJsonRequest jobsCreateWithSuppliedJsonRequest =
      new JobsCreateWithSuppliedJsonRequest.Builder(null)
          .addInput("1", "github@laszlocsontos.com", "Laszlo Csontos")
          .withAutoParse(true)
          .withAutoStart(true)
          .withFilename("test.csv")
          .build();

    assertNotNull(jobsCreateWithSuppliedJsonRequest);

    printJson(jobsCreateWithSuppliedJsonRequest);
  }

}
