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

  /**
   * Date format internal to Neverbounce's API.
   */
  public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

  private DateUtils() {
  }

  /**
   * Converts the given {@code dateAsString} to {@link Date}.
   *
   * @param dateAsString date as a string
   * @return parsed {@link Date}
   */
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

  /**
   * Converts the given {@code date} to {@link String}.
   *
   * @param date parsed {@link Date}
   * @return date as a string
   */
  public static String fromDate(Date date) {
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    return dateFormat.format(date);
  }

}
