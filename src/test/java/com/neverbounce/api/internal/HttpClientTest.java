package com.neverbounce.api.internal;

import static com.google.api.client.json.Json.MEDIA_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.neverbounce.api.client.exception.NeverbounceApiException;
import com.neverbounce.api.model.AccountInfoResponse;
import com.neverbounce.api.model.JobsCreateResponse;
import com.neverbounce.api.model.JobsCreateWithRemoteUrlRequest;
import com.neverbounce.api.model.Status;
import java.io.IOException;
import org.junit.Test;

/**
 * Created by lcsontos on 7/25/17.
 */
public class HttpClientTest {

  private static final String API_KEY = "test";

  @Test
  public void testGetForObject_withOK() throws Exception {
    String content = IoUtils.getResourceAsString("account_info_response.json");
    HttpClient httpClient = createHttpClient(200, MEDIA_TYPE, content);

    AccountInfoResponse accountInfoResponse =
        httpClient.getForObject("account/info", AccountInfoResponse.class);

    assertNotNull(accountInfoResponse);
    assertEquals(Status.SUCCESS, accountInfoResponse.getStatus());
  }

  @Test
  public void testGetForObject_withBadRequest() throws Exception {
    String content = IoUtils.getResourceAsString("error_response.json");
    HttpClient httpClient = createHttpClient(400, MEDIA_TYPE, content);

    try {
      httpClient.getForObject("account/info", AccountInfoResponse.class);
      fail(NeverbounceApiException.class.getName() + " should have been thrown");
    } catch (NeverbounceApiException nae) {
      assertEquals(Status.GENERAL_FAILURE, nae.getStatus());
      assertEquals(5, nae.getExecutionTime());
    }
  }

  @Test
  public void testPostForObject() throws Exception {
    String content = IoUtils.getResourceAsString("job_create_response.json");
    HttpClient httpClient = createHttpClient(200, MEDIA_TYPE, content);

    JobsCreateWithRemoteUrlRequest jobsCreateWithRemoteUrlRequest =
        (JobsCreateWithRemoteUrlRequest)
            new JobsCreateWithRemoteUrlRequest.Builder(null)
                .withInput("test.csv")
                .withAutoParse(true)
                .withAutoStart(true)
                .withFilename("test.csv")
                .build();

    JobsCreateResponse jobsCreateResponse =
        httpClient.postForObject(
            "jobs/create", jobsCreateWithRemoteUrlRequest, JobsCreateResponse.class);

    assertNotNull(jobsCreateResponse);
    assertEquals(150970, jobsCreateResponse.getJobId());
  }

  private HttpClient createHttpClient(final int statusCode, final String mediaType,
      final String content) {
    HttpTransport httpTransport = new MockHttpTransport() {

      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
        return new MockLowLevelHttpRequest() {

          @Override
          public LowLevelHttpResponse execute() throws IOException {
            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.setStatusCode(statusCode);
            response.setContentType(mediaType);
            response.setContent(content);
            return response;
          }

        };
      }

    };

    return new HttpClientImpl(API_KEY, httpTransport);
  }

}
