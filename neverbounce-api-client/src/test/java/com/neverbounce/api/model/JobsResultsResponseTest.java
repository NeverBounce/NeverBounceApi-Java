package com.neverbounce.api.model;

import static com.neverbounce.api.model.Result.INVALID;
import static com.neverbounce.api.model.Status.SUCCESS;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by lcsontos on 7/27/17.
 */
public class JobsResultsResponseTest extends AbstractResponseTest<JobsResultsResponse> {

    @Override
    protected Class<JobsResultsResponse> getResponseClass() {
        return JobsResultsResponse.class;
    }

    @Override
    protected String getResponseResourceName() {
        return "job_results_response.json";
    }

    @Override
    protected void assertResponse(JobsResultsResponse response) {
        assertNotNull(response);
        assertEquals(3, response.getTotalResults());
        assertEquals(1, response.getTotalPages());

        // Query
        assertEquals(251319, response.getQuery().getJobId());
        assertEquals(1, response.getQuery().getValids());
        assertEquals(1, response.getQuery().getInvalids());
        assertEquals(1, response.getQuery().getDisposables());
        assertEquals(1, response.getQuery().getCatchalls());
        assertEquals(1, response.getQuery().getUnknowns());
        assertEquals(0, response.getQuery().getPage());
        assertEquals(10, response.getQuery().getItemsPerPage());

        // Results
        List<JobResult> results = response.getResults();
        assertNotNull(results);
        assertFalse(results.isEmpty());

        // First result
        JobResult result = results.get(0);
        assertNotNull(result);

        // Email Data
        EmailData data = result.getEmailData();
        assertNotNull(data);
        assertEquals("email", data.getEmail());
        assertEquals("id", data.getId());
        assertEquals("name", data.getName());

        // Verification
        SingleCheckResponse verification = result.getVerification();
        assertNotNull(verification);
        assertEquals(SUCCESS, verification.getStatus());
        assertEquals(INVALID, verification.getResult());

        // Address info
        SingleCheckResponse.AddressInfo addressInfo = verification.getAddressInfo();
        assertNotNull(addressInfo);
        assertEquals("email", addressInfo.getOriginalEmail());
    }

}
