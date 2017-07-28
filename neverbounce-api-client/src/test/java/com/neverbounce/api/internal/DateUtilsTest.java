package com.neverbounce.api.internal;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;

/**
 * Created by lcsontos on 7/28/17.
 */
public class DateUtilsTest {

  @Test
  public void testToDate() {
    Date date = DateUtils.toDate("2017-04-15 20:00:06");
    assertNotNull(date);
    assertEquals(117, date.getYear());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToDate_withInvalid() {
    Date date = DateUtils.toDate("invalid");
  }

  @Test
  public void testFromDate() {
    Date date = new Date(117, 3, 15, 20, 0, 6);
    assertEquals("2017-04-15 20:00:06", DateUtils.fromDate(date));
  }

}
