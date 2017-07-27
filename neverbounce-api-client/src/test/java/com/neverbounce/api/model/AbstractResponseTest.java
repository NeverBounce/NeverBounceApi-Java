package com.neverbounce.api.model;

import static com.neverbounce.api.internal.HttpClient.JSON_FACTORY;

import com.google.api.client.json.JsonParser;
import com.neverbounce.api.internal.IoUtils;
import org.junit.Test;

/**
 * Created by lcsontos on 7/27/17.
 */
public abstract class AbstractResponseTest<R extends Response> {

  @Test
  public void testResponse() throws Exception {
    String content = IoUtils.getResourceAsString(getResponseResourceName());
    JsonParser jsonParser = JSON_FACTORY.createJsonParser(content);
    R response = jsonParser.parse(getResponseClass());
    assertResponse(response);
  }

  protected abstract Class<R> getResponseClass();

  protected abstract String getResponseResourceName();

  protected abstract void assertResponse(R response);

}
