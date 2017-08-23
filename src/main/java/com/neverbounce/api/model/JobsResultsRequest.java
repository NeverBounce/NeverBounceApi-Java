package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-results
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-results">Jobs Results</a>
 */
public class JobsResultsRequest extends AbstractJobsRequest<JobsResultsResponse> {

  public static final String PATH = "jobs/results";

  @Key
  private final Integer page;

  @Key("items_per_page")
  private final Integer itemsPerPage;

  JobsResultsRequest(
      HttpClient httpClient, long jobId, Integer page, Integer itemsPerPage) {

    super(httpClient, jobId);
    this.page = page;
    this.itemsPerPage = itemsPerPage;
  }

  @Override
  public JobsResultsResponse execute() {
    return getHttpClient().getForObject(PATH, this, JobsResultsResponse.class);
  }

  public static class Builder extends AbstractJobsRequest.Builder<JobsResultsRequest, Builder> {

    private Integer page;
    private Integer itemsPerPage;

    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    public Builder withPage(Integer page) {
      this.page = page;
      return this;
    }

    public Builder withItemsPerPage(Integer itemsPerPage) {
      this.itemsPerPage = itemsPerPage;
      return this;
    }

    @Override
    protected JobsResultsRequest doBuild() {
      return new JobsResultsRequest(httpClient, jobId, page, itemsPerPage);
    }

  }

}
