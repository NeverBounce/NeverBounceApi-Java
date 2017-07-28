package com.neverbounce.api.examples;

import static com.neverbounce.api.internal.JsonUtils.printJson;

import com.neverbounce.api.client.NeverbounceClient;
import com.neverbounce.api.client.NeverbounceClientFactory;
import com.neverbounce.api.model.AccountInfoRequest;
import com.neverbounce.api.model.AccountInfoResponse;
import com.neverbounce.api.model.JobsCreateResponse;
import com.neverbounce.api.model.JobsDeleteResponse;
import com.neverbounce.api.model.JobsResultsResponse;
import com.neverbounce.api.model.JobsSearchResponse;
import com.neverbounce.api.model.JobsStatusResponse;
import com.neverbounce.api.model.SingleCheckResponse;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class Main {

  /**
   * Main method.
   *
   * @param args command line arguments
   * @throws Exception Exception thrown upon errors
   */
  public static void main(String... args) throws Exception {
    Options options = new Options();
    options.addOption("a", "api-key", true, "API Key");
    CommandLineParser commandLineParser = new DefaultParser();
    CommandLine commandLine = commandLineParser.parse(options, args);

    if (!commandLine.hasOption("a")) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("Main", options);
      return;
    }

    NeverbounceClient neverbounceClient =
        NeverbounceClientFactory.create(commandLine.getOptionValue("a"));

    // Account info
    AccountInfoRequest accountInfoRequest = neverbounceClient.createAccountInfoRequest();
    AccountInfoResponse accountInfoResponse = accountInfoRequest.execute();
    printJson(accountInfoResponse);

    // Single check
    SingleCheckResponse singleCheckResponse = neverbounceClient
            .prepareSingleCheckRequest()
            .withEmail("github@laszlocsontos.com")
            .withAddressInfo(true)
            .withCreditsInfo(true)
            .withTimeout(300)
            .build()
            .execute();

    printJson(singleCheckResponse);

    // Job creation
    JobsCreateResponse jobsCreateResponse = neverbounceClient
        .prepareJobsCreateWithSuppliedJsonRequest()
        .addInput("github@laszlocsontos.com", "Laszlo Csontos")
        .withAutoParse(true)
        .withAutoStart(true)
        .withFilename("test.csv")
        .build()
        .execute();

    printJson(jobsCreateResponse);

    long jobId = 280319; //jobsCreateResponse.getJobId();

    // Job results
    JobsResultsResponse jobsResultsResponse = neverbounceClient
        .prepareJobsResultsRequest()
        .withJobId(jobId)
        .build()
        .execute();

    printJson(jobsResultsResponse);

    // Job status
    JobsStatusResponse jobsStatusResponse = neverbounceClient
        .prepareJobsStatusRequest()
        .withJobId(jobId)
        .build()
        .execute();

    printJson(jobsStatusResponse);

    // Job search
    JobsSearchResponse jobsSearchResponse = neverbounceClient
        .prepareJobsSearchRequest()
        .withJobId(jobId)
        .build()
        .execute();

    printJson(jobsSearchResponse);

    // Job delete
    JobsDeleteResponse jobsDeleteResponse = neverbounceClient
        .prepareJobsDeleteRequest()
        .withJobId(jobId)
        .build()
        .execute();

    printJson(jobsDeleteResponse);
  }

}
