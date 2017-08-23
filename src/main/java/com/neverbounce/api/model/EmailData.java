package com.neverbounce.api.model;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.Map;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class EmailData extends GenericData {

  @Key
  private String id;

  @Key
  private String email;

  @Key
  private String name;

  /**
   * Creates and empty {@code EmailData}.
   */
  public EmailData() {
  }

  /**
   * Creates an {@code EmailData} with common fields ({@code id}, {@code email}, {@code name})
   * initialized.
   *
   * @param id ID
   * @param email Email
   * @param name Name
   */
  public EmailData(String id, String email, String name) {
    this.id = id;
    this.email = email;
    this.name = name;
  }

  /**
   * Creates an {@code EmailData} with arbitrary key/value pairs.
   *
   * @param data Data
   */
  public EmailData(Map<String, Object> data) {
    for (Map.Entry<String, Object> entry : data.entrySet()) {
      set(entry.getKey(), entry.getValue());
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
