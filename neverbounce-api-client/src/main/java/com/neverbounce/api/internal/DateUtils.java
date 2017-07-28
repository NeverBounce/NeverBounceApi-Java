package com.neverbounce.api.internal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class DateUtils {

  private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

  private DateUtils() {
  }

  public static Date toDate(String dateAsString) {
    try {
      DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
      return dateFormat.parse(dateAsString);
    } catch (ParseException pe) {
      throw new IllegalArgumentException(
          dateAsString + " couldn't be parsed with pattern " + DATE_FORMAT, pe
      );
    }
  }

  public static String fromDate(Date date) {
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    return dateFormat.format(date);
  }

}
