package com.neverbounce.api.model;

import static com.neverbounce.api.internal.IntegerUtils.toInteger;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-search">Jobs Search</a>
 */
public class JobsSearchRequest extends AbstractJobsRequest<JobsSearchResponse> {

  public static final String PATH = "jobs/search";

  @Key
  private final String filename;

  @Key
  private final Integer completed;

  @Key
  private final Integer processing;

  @Key
  private final Integer indexing;

  @Key
  private final Integer failed;

  @Key("manual_review")
  private final Integer manualReview;

  @Key
  private final Integer unpurchased;

  @Key
  private final Integer page;

  @Key("items_per_page")
  private final Integer itemsPerPage;

  JobsSearchRequest(HttpClient httpClient, Long jobId,
      String filename, Integer completed, Integer processing, Integer indexing,
      Integer failed, Integer manualReview, Integer unpurchased, Integer page,
      Integer itemsPerPage) {

    super(httpClient, jobId);
    this.filename = filename;
    this.completed = completed;
    this.processing = processing;
    this.indexing = indexing;
    this.failed = failed;
    this.manualReview = manualReview;
    this.unpurchased = unpurchased;
    this.page = page;
    this.itemsPerPage = itemsPerPage;
  }

  @Override
  public JobsSearchResponse execute() {
    return getHttpClient().getForObject(PATH, this, JobsSearchResponse.class);
  }

  public static class Builder extends AbstractJobsRequest.Builder<JobsSearchRequest, Builder> {

    private String filename;
    private Boolean completed;
    private Boolean processing;
    private Boolean indexing;
    private Boolean failed;
    private Boolean manualReview;
    private Boolean unpurchased;
    private Integer page;
    private Integer itemsPerPage;


    public Builder(HttpClient httpClient) {
      super(httpClient);
    }

    public Builder withFilename(String filename) {
      this.filename = filename;
      return this;
    }

    public Builder withCompleted(Boolean completed) {
      this.completed = completed;
      return this;
    }

    public Builder withProcessing(Boolean processing) {
      this.processing = processing;
      return this;
    }

    public Builder withIndexing(Boolean indexing) {
      this.indexing = indexing;
      return this;
    }

    public Builder withFailed(Boolean failed) {
      this.failed = failed;
      return this;
    }

    public Builder withManualReview(Boolean manualReview) {
      this.manualReview = manualReview;
      return this;
    }

    public Builder withUnpurchased(Boolean unpurchased) {
      this.unpurchased = unpurchased;
      return this;
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
    protected JobsSearchRequest doBuild() {
      return new JobsSearchRequest(
          httpClient,
          jobId,
          filename,
          toInteger(completed),
          toInteger(processing),
          toInteger(indexing),
          toInteger(failed),
          toInteger(manualReview),
          toInteger(unpurchased),
          page,
          itemsPerPage
      );
    }

    @Override
    protected void validate() {
      // All arguments of a search request might be null / empty, hence we perform no checks here.
    }

  }

}
