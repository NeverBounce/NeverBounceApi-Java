package com.neverbounce.api.internal;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class IntegerUtils {

  private static Integer FALSE = 0;
  private static Integer TRUE = 1;

  private IntegerUtils() {
  }

  /**
   * Convers the given {@link Boolean} to {@link Integer}.
   *
   * @param value {@link Boolean} value
   * @return 1 if {@code true}, {@code false} otherwise
   */
  public static Integer toInteger(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value) {
      return TRUE;
    }
    return FALSE;
  }

}
