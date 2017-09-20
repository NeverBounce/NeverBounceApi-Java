package com.neverbounce.api.client;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

import com.neverbounce.api.internal.HttpClient;
import com.neverbounce.api.internal.NeverbounceClientImpl;
import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.AccountInfoResponse;
import com.neverbounce.api.model.JobsCreateResponse;
import com.neverbounce.api.model.JobsCreateWithRemoteUrlRequest;
import com.neverbounce.api.model.JobsCreateWithSuppliedJsonRequest;
import com.neverbounce.api.model.JobsDeleteRequest;
import com.neverbounce.api.model.JobsDeleteResponse;
import com.neverbounce.api.model.JobsParseRequest;
import com.neverbounce.api.model.JobsParseResponse;
import com.neverbounce.api.model.JobsResultsRequest;
import com.neverbounce.api.model.JobsResultsResponse;
import com.neverbounce.api.model.JobsSearchRequest;
import com.neverbounce.api.model.JobsSearchResponse;
import com.neverbounce.api.model.JobsStartRequest;
import com.neverbounce.api.model.JobsStartResponse;
import com.neverbounce.api.model.JobsStatusRequest;
import com.neverbounce.api.model.JobsStatusResponse;
import com.neverbounce.api.model.PoeConfirmRequest;
import com.neverbounce.api.model.PoeConfirmResponse;
import com.neverbounce.api.model.SingleCheckRequest;
import com.neverbounce.api.model.SingleCheckResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by lcsontos on 7/26/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class NeverbounceClientTest {

  @Mock
  private HttpClient httpClient;
  private NeverbounceClient neverbounceClient;

  @Before
  public void before() {
    neverbounceClient = new NeverbounceClientImpl(httpClient);
  }

  @Test
  public void testAccountInfoRequest() {
    when(
        httpClient.getForObject(AccountInfoRequest.PATH, AccountInfoResponse.class)
    ).thenReturn(
        new AccountInfoResponse()
    );

    AccountInfoRequest accountInfoRequest = neverbounceClient.createAccountInfoRequest();
    AccountInfoResponse accountInfoResponse = accountInfoRequest.execute();

    assertNotNull(accountInfoResponse);
  }

  @Test
  public void testSingleCheckRequest() {
    when(
        httpClient.getForObject(
            eq(SingleCheckRequest.PATH),
            any(SingleCheckRequest.class),
            eq(SingleCheckResponse.class))
    ).thenReturn(
        new SingleCheckResponse()
    );

    SingleCheckRequest singleCheckRequest = neverbounceClient
        .prepareSingleCheckRequest()
        .withEmail("github@laszlocsontos.com")
        .build();

    SingleCheckResponse singleCheckResponse = singleCheckRequest.execute();

    assertNotNull(singleCheckResponse);
  }

  @Test
  public void testJobsResultsRequest() {
    when(
        httpClient.getForObject(
            eq(JobsResultsRequest.PATH),
            any(JobsResultsRequest.class),
            eq(JobsResultsResponse.class))
    ).thenReturn(
        new JobsResultsResponse()
    );

    JobsResultsRequest jobsResultsRequest = neverbounceClient
        .prepareJobsResultsRequest()
        .withJobId(1)
        .build();

    JobsResultsResponse jobsResultsResponse = jobsResultsRequest.execute();

    assertNotNull(jobsResultsResponse);
  }

  @Test
  public void testJobsStatusRequest() {
    when(
        httpClient.getForObject(
            eq(JobsStatusRequest.PATH),
            any(JobsStatusRequest.class),
            eq(JobsStatusResponse.class))
    ).thenReturn(
        new JobsStatusResponse()
    );

    JobsStatusRequest jobsStatusRequest = neverbounceClient
        .prepareJobsStatusRequest()
        .withJobId(1)
        .build();

    JobsStatusResponse jobsStatusResponse = jobsStatusRequest.execute();

    assertNotNull(jobsStatusResponse);
  }

  @Test
  public void testJobsSearchRequest() {
    when(
        httpClient.getForObject(
            eq(JobsSearchRequest.PATH),
            any(JobsSearchRequest.class),
            eq(JobsSearchResponse.class))
    ).thenReturn(
        new JobsSearchResponse()
    );

    JobsSearchRequest jobsSearchRequest = neverbounceClient
        .prepareJobsSearchRequest()
        .withJobId(1)
        .build();

    JobsSearchResponse jobsSearchResponse = jobsSearchRequest.execute();

    assertNotNull(jobsSearchResponse);
  }

  @Test
  public void testJobsCreateWithRemoteUrlRequest() {
    when(
        httpClient.postForObject(
            eq(JobsCreateWithRemoteUrlRequest.PATH),
            any(JobsCreateWithRemoteUrlRequest.class),
            eq(JobsCreateResponse.class))
    ).thenReturn(
        new JobsCreateResponse()
    );

    JobsCreateWithRemoteUrlRequest jobsCreateWithRemoteUrlRequest = neverbounceClient
        .prepareJobsCreateWithRemoteUrlRequest()
        .withInput("test.csv")
        .withAutoParse(true)
        .withAutoStart(true)
        .withFilename("test.csv")
        .build();

    JobsCreateResponse jobsCreateResponse = jobsCreateWithRemoteUrlRequest.execute();

    assertNotNull(jobsCreateResponse);
  }

  @Test
  public void testJobsCreateWithSuppliedJsonRequest() {
    when(
        httpClient.postForObject(
            eq(JobsCreateWithSuppliedJsonRequest.PATH),
            any(JobsCreateWithSuppliedJsonRequest.class),
            eq(JobsCreateResponse.class))
    ).thenReturn(
        new JobsCreateResponse()
    );

    JobsCreateWithSuppliedJsonRequest jobsCreateWithRemoteUrlRequest = neverbounceClient
        .prepareJobsCreateWithSuppliedJsonRequest()
        .addInput("github@laszlocsontos.com", "Laszlo Csontos")
        .withAutoParse(true)
        .withAutoStart(true)
        .withFilename("test.csv")
        .build();

    JobsCreateResponse jobsCreateResponse = jobsCreateWithRemoteUrlRequest.execute();

    assertNotNull(jobsCreateResponse);
  }

  @Test
  public void testJobsDeleteRequest() {
    when(
        httpClient.postForObject(
            eq(JobsDeleteRequest.PATH),
            any(JobsDeleteRequest.class),
            eq(JobsDeleteResponse.class))
    ).thenReturn(
        new JobsDeleteResponse()
    );

    JobsDeleteRequest jobsDeleteRequest = neverbounceClient
        .prepareJobsDeleteRequest()
        .withJobId(1)
        .build();

    JobsDeleteResponse jobsDeleteResponse = jobsDeleteRequest.execute();

    assertNotNull(jobsDeleteResponse);
  }

  @Test
  public void testJobsStartRequest() {
    when(
        httpClient.postForObject(
            eq(JobsStartRequest.PATH),
            any(JobsStartRequest.class),
            eq(JobsStartResponse.class))
    ).thenReturn(
        new JobsStartResponse()
    );

    JobsStartRequest jobsStartRequest = neverbounceClient
        .prepareJobsStartRequest()
        .withJobId(1)
        .build();

    JobsStartResponse jobsStartResponse = jobsStartRequest.execute();

    assertNotNull(jobsStartResponse);
  }

  @Test
  public void testJobsParseRequest() {
    when(
        httpClient.postForObject(
            eq(JobsParseRequest.PATH),
            any(JobsParseRequest.class),
            eq(JobsParseResponse.class))
    ).thenReturn(
        new JobsParseResponse()
    );

    JobsParseRequest jobsParseRequest = neverbounceClient
        .prepareJobsParseRequest()
        .withJobId(1)
        .withAutoStart(true)
        .build();

    JobsParseResponse jobsParseResponse = jobsParseRequest.execute();

    assertNotNull(jobsParseResponse);
  }

  /*@Test
  public void testPoeConfirmRequest() {
    when(
        httpClient.postForObject(
            eq(PoeConfirmRequest.PATH),
            any(PoeConfirmRequest.class),
            eq(PoeConfirmResponse.class))
    ).thenReturn(
        new PoeConfirmResponse()
    );
	  PoeConfirmRequest poeConfirmRequest = neverbounceClient
		        .preparePoeConfirmRequest()
		        .withEmail("github@laszlocsontos.com")
		        .withTransactionId("trnsid")
		        .withConfirmationToken("asdf")
		        .withResult("valid")
		        .build();
	  PoeConfirmResponse poeConfirmResponse = poeConfirmRequest.execute();
    //assertNotNull(poeConfirmResponse);
  }*/
}
