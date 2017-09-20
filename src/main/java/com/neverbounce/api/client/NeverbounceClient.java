package com.neverbounce.api.client;

import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.JobsCreateWithRemoteUrlRequest;
import com.neverbounce.api.model.JobsCreateWithSuppliedJsonRequest;
import com.neverbounce.api.model.JobsDeleteRequest;
import com.neverbounce.api.model.JobsParseRequest;
import com.neverbounce.api.model.JobsResultsRequest;
import com.neverbounce.api.model.JobsSearchRequest;
import com.neverbounce.api.model.JobsStartRequest;
import com.neverbounce.api.model.JobsStatusRequest;
import com.neverbounce.api.model.PoeConfirmRequest;
import com.neverbounce.api.model.SingleCheckRequest;


/**
 * Entry point to Neverbounce's API.
 *
 * <p>Many of the inputs and outputs of the client object's functions map fairly closely to
 * NeverBounce's raw v4 API, reading through the will be valuable in conjunction with using the
 * Javadoc.</p>
 *
 * <p><strong>Note: this implementation is thread-safe.</strong></p>
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference">NeverBounce API Reference</a>
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

  JobsParseRequest.Builder prepareJobsParseRequest();
  
  PoeConfirmRequest.Builder preparePoeConfirmRequest();

}
