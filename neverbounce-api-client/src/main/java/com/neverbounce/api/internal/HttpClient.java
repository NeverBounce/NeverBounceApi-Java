package com.neverbounce.api.internal;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.neverbounce.api.model.Request;
import com.neverbounce.api.model.Response;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface HttpClient {

  String API_BASE_URL = "https://api.neverbounce.com/v4";
  String API_KEY = "key";

  String HTTP_METHOD_GET = "GET";
  String HTTP_METHOD_POST = "POST";

  JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

  <R extends Response> R getForObject(String path, Class<R> responseClass);

  <R extends Response> R getForObject(String path, Request<R> request, Class<R> responseClass);

  <R extends Response> R postForObject(String path, Request<R> request, Class<R> responseClass);

}
