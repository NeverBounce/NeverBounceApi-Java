package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsSearchRequest extends AbstractRequest<JobsSearchResponse> {

  public static final String PATH = "jobs/search";

  @Key("job_id")
  private final Long jobId;

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

  public JobsSearchRequest(HttpClient httpClient, Long jobId,
      String filename, Integer completed, Integer processing, Integer indexing,
      Integer failed, Integer manualReview, Integer unpurchased, Integer page,
      Integer itemsPerPage) {

    super(httpClient);
    this.jobId = jobId;
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

  public static class Builder extends AbstractRequestBuilder<JobsSearchRequest> {

    private static Integer FALSE = new Integer(0);
    private static Integer TRUE = new Integer(1);

    private Long jobId;
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

    public JobsSearchRequest.Builder withJobId(long jobId) {
      this.jobId = jobId;
      return this;
    }

    public JobsSearchRequest.Builder withFilename(String filename) {
      this.filename = filename;
      return this;
    }

    public JobsSearchRequest.Builder withCompleted(Boolean completed) {
      this.completed = completed;
      return this;
    }

    public JobsSearchRequest.Builder withProcessing(Boolean processing) {
      this.processing = processing;
      return this;
    }

    public JobsSearchRequest.Builder withIndexing(Boolean indexing) {
      this.indexing = indexing;
      return this;
    }

    public JobsSearchRequest.Builder withFailed(Boolean failed) {
      this.failed = failed;
      return this;
    }

    public JobsSearchRequest.Builder withManualReview(Boolean manualReview) {
      this.manualReview = manualReview;
      return this;
    }

    public JobsSearchRequest.Builder withUnpurchased(Boolean unpurchased) {
      this.unpurchased = unpurchased;
      return this;
    }

    public JobsSearchRequest.Builder withPage(Integer page) {
      this.page = page;
      return this;
    }

    public JobsSearchRequest.Builder withItemsPerPage(Integer itemsPerPage) {
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
      Preconditions.checkState(jobId != null, "job_id must not be null");
    }

    private Integer toInteger(Boolean value) {
      if (value == null) {
        return null;
      }
      if (value) {
        return TRUE;
      }

      return FALSE;
    }

  }

}
