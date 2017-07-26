package com.neverbounce.api.model;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface Request<R extends Response> {

  R execute();

}
