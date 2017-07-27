package com.neverbounce.api.client;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

import com.neverbounce.api.internal.HttpClient;
import com.neverbounce.api.internal.NeverbounceClientImpl;
import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.AccountInfoResponse;
import com.neverbounce.api.model.JobsResultsRequest;
import com.neverbounce.api.model.JobsResultsResponse;
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

}
