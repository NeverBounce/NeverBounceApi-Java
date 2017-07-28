package com.neverbounce.api.internal;

import static com.neverbounce.api.internal.HttpClient.JSON_FACTORY;

import com.google.api.client.json.JsonGenerator;
import com.neverbounce.api.model.Response;
import java.io.PrintWriter;
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
    JsonGenerator jsonGenerator = JSON_FACTORY.createJsonGenerator(writer);
    jsonGenerator.serialize(data);
    writer.write('\n');
    writer.flush();
  }

}
