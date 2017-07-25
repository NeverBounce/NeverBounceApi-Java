package com.neverbounce.api.model;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface Response {

  Status getStatus();

  long getExecutionTime();

}
