package com.neverbounce.api.client;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.neverbounce.api.internal.HttpClient;
import com.neverbounce.api.internal.NeverbounceClientImpl;
import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.AccountInfoResponse;
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

}
