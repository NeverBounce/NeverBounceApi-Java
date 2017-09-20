package com.neverbounce.api.internal;

import com.neverbounce.api.client.NeverbounceClient;
import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.JobsCreateWithRemoteUrlRequest;
import com.neverbounce.api.model.JobsCreateWithSuppliedJsonRequest;
import com.neverbounce.api.model.JobsDeleteRequest;
import com.neverbounce.api.model.JobsDeleteRequest.Builder;
import com.neverbounce.api.model.JobsParseRequest;
import com.neverbounce.api.model.JobsResultsRequest;
import com.neverbounce.api.model.JobsSearchRequest;
import com.neverbounce.api.model.JobsStartRequest;
import com.neverbounce.api.model.JobsStatusRequest;
import com.neverbounce.api.model.PoeConfirmRequest;
import com.neverbounce.api.model.SingleCheckRequest;

/**
 * Internal use only.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public final class NeverbounceClientImpl implements NeverbounceClient {

  private final HttpClient httpClient;

  public NeverbounceClientImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public AccountInfoRequest createAccountInfoRequest() {
    return new AccountInfoRequest(httpClient);
  }

  @Override
  public SingleCheckRequest.Builder prepareSingleCheckRequest() {
    return new SingleCheckRequest.Builder(httpClient);
  }

  @Override
  public JobsResultsRequest.Builder prepareJobsResultsRequest() {
    return new JobsResultsRequest.Builder(httpClient);
  }

  @Override
  public JobsStatusRequest.Builder prepareJobsStatusRequest() {
    return new JobsStatusRequest.Builder(httpClient);
  }

  @Override
  public JobsSearchRequest.Builder prepareJobsSearchRequest() {
    return new JobsSearchRequest.Builder(httpClient);
  }

  @Override
  public JobsCreateWithRemoteUrlRequest.Builder prepareJobsCreateWithRemoteUrlRequest() {
    return new JobsCreateWithRemoteUrlRequest.Builder(httpClient);
  }

  @Override
  public JobsCreateWithSuppliedJsonRequest.Builder prepareJobsCreateWithSuppliedJsonRequest() {
    return new JobsCreateWithSuppliedJsonRequest.Builder(httpClient);
  }

  @Override
  public JobsDeleteRequest.Builder prepareJobsDeleteRequest() {
    return new JobsDeleteRequest.Builder(httpClient);
  }

  @Override
  public JobsStartRequest.Builder prepareJobsStartRequest() {
    return new JobsStartRequest.Builder(httpClient);
  }

  @Override
  public JobsParseRequest.Builder prepareJobsParseRequest() {
    return new JobsParseRequest.Builder(httpClient);
  }

  @Override
  public PoeConfirmRequest.Builder preparePoeConfirmRequest() {
    return new PoeConfirmRequest.Builder(httpClient);
  }

}
