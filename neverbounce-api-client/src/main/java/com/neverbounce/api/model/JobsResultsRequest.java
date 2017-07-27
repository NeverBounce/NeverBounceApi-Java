package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.neverbounce.api.internal.HttpClient;

/**
 * https://developers.neverbounce.com/v4.0/reference#jobs-results
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsResultsRequest extends AbstractRequest<JobsResultsResponse> {

    public static final String PATH = "jobs/results";

    @Key("job_id")
    private final long jobId;

    @Key
    private final Integer page;

    @Key("items_per_page")
    private final Integer itemsPerPage;

    public JobsResultsRequest(
            HttpClient httpClient, long jobId, Integer page, Integer itemsPerPage) {
        super(httpClient);
        this.jobId = jobId;
        this.page = page;
        this.itemsPerPage = itemsPerPage;
    }

    @Override
    public JobsResultsResponse execute() {
        return getHttpClient().getForObject(PATH, this, JobsResultsResponse.class);
    }

    public static class Builder extends AbstractRequestBuilder<JobsResultsRequest> {

        private Long jobId;
        private Integer page;
        private Integer itemsPerPage;

        public Builder(HttpClient httpClient) {
            super(httpClient);
        }

        public JobsResultsRequest.Builder withJobId(long jobId) {
            this.jobId = jobId;
            return this;
        }

        public JobsResultsRequest.Builder withPage(Integer page) {
            this.page = page;
            return this;
        }

        public JobsResultsRequest.Builder withItemsPerPage(Integer itemsPerPage) {
            this.itemsPerPage = itemsPerPage;
            return this;
        }

        @Override
        protected JobsResultsRequest doBuild() {
            return new JobsResultsRequest(httpClient, jobId, page, itemsPerPage);
        }

        @Override
        protected void validate() {
            Preconditions.checkState(jobId != null, "job_id must not be null");
        }

    }

}
