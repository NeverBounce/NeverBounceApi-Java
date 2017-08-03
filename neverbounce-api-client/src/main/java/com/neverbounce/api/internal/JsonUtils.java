package com.neverbounce.api.internal;

import static com.neverbounce.api.internal.HttpClient.JSON_FACTORY;

import com.google.api.client.json.JsonGenerator;
import com.neverbounce.api.model.Response;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by lcsontos on 7/28/17.
 */
public final class JsonUtils {

  private JsonUtils() {
  }

  /**
   * Prints the given {@code data} to the standard output as JSON.
   *
   * @param data data object
   * @throws Exception Upon errors
   */
  public static void printJson(Object data) throws Exception {
    Writer writer = new PrintWriter(System.out);
    serialize(data, writer);
    writer.write('\n');
    writer.flush();
  }

  /**
   * Serializes the given {@code data} to a JSON String.
   *
   * @param data data object
   * @return JSON String
   * @throws Exception Upon errors
   */
  public static String toJson(Object data) throws Exception {
    StringWriter stringWriter = new StringWriter();
    serialize(data, stringWriter);
    return stringWriter.toString();
  }

  private static void serialize(Object data, Writer writer) throws Exception {
    JsonGenerator jsonGenerator = JSON_FACTORY.createJsonGenerator(writer);
    jsonGenerator.serialize(data);
  }

}
