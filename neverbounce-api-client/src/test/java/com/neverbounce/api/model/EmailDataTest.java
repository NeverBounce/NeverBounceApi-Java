package com.neverbounce.api.model;

import static com.neverbounce.api.internal.JsonUtils.toJson;
import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Created by lcsontos on 8/2/17.
 */
public class EmailDataTest {

  @Test
  public void testEmpty() throws Exception {
    EmailData data = new EmailData();

    assertNull(data.getId());
    assertNull(data.getEmail());
    assertNull(data.getName());

    assertEquals("{}", toJson(data));
  }

  @Test
  public void testPreinit() throws Exception {
    EmailData data = new EmailData("1", "github@laszlocsontos.com", "Laszlo Csontos");

    assertEquals("1", data.getId());
    assertEquals("1", data.get("id"));

    assertEquals("github@laszlocsontos.com", data.getEmail());
    assertEquals("github@laszlocsontos.com", data.get("email"));

    assertEquals("Laszlo Csontos", data.getName());
    assertEquals("Laszlo Csontos", data.get("name"));

    assertEquals(
        "{\"email\":\"github@laszlocsontos.com\",\"id\":\"1\","
        + "\"name\":\"Laszlo Csontos\"}",
        toJson(data));
  }

  @Test
  public void testCustomFields() throws Exception {
    Map<String, Object> fields = new LinkedHashMap<String, Object>();
    fields.put("id", "1");
    fields.put("email", "github@laszlocsontos.com");
    fields.put("name", "Laszlo Csontos");
    fields.put("customerId", "1");

    EmailData data = new EmailData(fields);

    assertEquals("1", data.getId());
    assertEquals("1", data.get("id"));

    assertEquals("github@laszlocsontos.com", data.getEmail());
    assertEquals("github@laszlocsontos.com", data.get("email"));

    assertEquals("Laszlo Csontos", data.getName());
    assertEquals("Laszlo Csontos", data.get("name"));

    assertEquals(
        "{\"email\":\"github@laszlocsontos.com\",\"id\":\"1\","
            + "\"name\":\"Laszlo Csontos\",\"customerId\":\"1\"}",
        toJson(data));
  }

}
