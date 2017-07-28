package com.neverbounce.api.client;

import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.JobsCreateWithRemoteUrlRequest;
import com.neverbounce.api.model.JobsCreateWithSuppliedJsonRequest;
import com.neverbounce.api.model.JobsDeleteRequest;
import com.neverbounce.api.model.JobsResultsRequest;
import com.neverbounce.api.model.JobsSearchRequest;
import com.neverbounce.api.model.JobsStartRequest;
import com.neverbounce.api.model.JobsStatusRequest;
import com.neverbounce.api.model.SingleCheckRequest;

/**
 * Entry point to NeverbounceClient's API.
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public interface NeverbounceClient {

  AccountInfoRequest createAccountInfoRequest();

  SingleCheckRequest.Builder prepareSingleCheckRequest();

  JobsResultsRequest.Builder prepareJobsResultsRequest();

  JobsStatusRequest.Builder prepareJobsStatusRequest();

  JobsSearchRequest.Builder prepareJobsSearchRequest();

  JobsCreateWithRemoteUrlRequest.Builder prepareJobsCreateWithRemoteUrlRequest();

  JobsCreateWithSuppliedJsonRequest.Builder prepareJobsCreateWithSuppliedJsonRequest();

  JobsDeleteRequest.Builder prepareJobsDeleteRequest();

  JobsStartRequest.Builder prepareJobsStartRequest();

}
