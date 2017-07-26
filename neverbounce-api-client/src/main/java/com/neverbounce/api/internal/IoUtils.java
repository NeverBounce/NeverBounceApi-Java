package com.neverbounce.api.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class IoUtils {

  private IoUtils() {
  }

  /**
   * Loads a resource from the classpath.
   *
   * @param resourceName Resource name
   * @return InputStream
   */
  public static InputStream getResource(String resourceName) {
    return IoUtils.class.getClassLoader().getResourceAsStream(resourceName);
  }

  /**
   * Loads a resource from the classpath as a {@code String}.
   *
   * @param resourceName Resource name
   * @return resource as a string
   * @throws IOException upon I/O errors
   */
  public static String getResourceAsString(String resourceName) throws IOException {
    return toString(getResource(resourceName));
  }

  /**
   * Converts an {@link InputStream} to a {@link String}.
   *
   * @param inputStream InputStream
   * @return InputStream as a String
   * @throws IOException upon I/O errors
   */
  public static String toString(InputStream inputStream) throws IOException {
    int bufferSize = 1024;
    char[] buffer = new char[bufferSize];
    StringBuilder stringBuilder = new StringBuilder();

    Reader in = new InputStreamReader(inputStream, "UTF-8");
    int count = -1;
    while ((count = in.read(buffer, 0, buffer.length)) >= 0) {
      stringBuilder.append(buffer, 0, count);
    }

    return stringBuilder.toString();
  }

}
