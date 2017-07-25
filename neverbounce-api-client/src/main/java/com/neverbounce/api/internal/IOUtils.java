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
public final class IOUtils {

  private IOUtils() {
  }

  public static InputStream getResource(String resourceName) {
    return IOUtils.class.getClassLoader().getResourceAsStream(resourceName);
  }

  public static String getResourceAsString(String resourceName) throws IOException {
    return toString(getResource(resourceName));
  }

  public static String toString(InputStream inputStream) throws IOException {
    int bufferSize = 1024;
    char[] buffer = new char[bufferSize];
    StringBuilder stringBuilder = new StringBuilder();

    Reader in = new InputStreamReader(inputStream, "UTF-8");
    int count = -1;
    while((count = in.read(buffer, 0, buffer.length)) >= 0) {
      stringBuilder.append(buffer, 0, count);
    }

    return stringBuilder.toString();
  }

}
