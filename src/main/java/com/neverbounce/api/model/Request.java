package com.neverbounce.api.model;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface Request<R extends Response> {

  /**
   * Executes the current request against Neverbounce's API.
   *
   * @return a response object
   */
  R execute();

}
