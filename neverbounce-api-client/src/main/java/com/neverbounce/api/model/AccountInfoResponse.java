package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#account-info">Account</a>
 */
public class AccountInfoResponse extends GenericResponse {

  @Key("billing_type")
  private String billingType;

  @Key("credits_info")
  private CreditsInfo creditsInfo;

  @Key("job_counts")
  private JobCounts jobCounts;

  public String getBillingType() {
    return billingType;
  }

  public void setBillingType(String billingType) {
    this.billingType = billingType;
  }

  public CreditsInfo getCreditsInfo() {
    return creditsInfo;
  }

  public void setCreditsInfo(CreditsInfo creditsInfo) {
    this.creditsInfo = creditsInfo;
  }

  public JobCounts getJobCounts() {
    return jobCounts;
  }

  public void setJobCounts(JobCounts jobCounts) {
    this.jobCounts = jobCounts;
  }

  public static class JobCounts {

    @Key("completed")
    private int completed;

    @Key("under_review")
    private int underReview;

    @Key("queued")
    private int queued;

    @Key("processing")
    private int processing;

    public int getCompleted() {
      return completed;
    }

    public void setCompleted(int completed) {
      this.completed = completed;
    }

    public int getUnderReview() {
      return underReview;
    }

    public void setUnderReview(int underReview) {
      this.underReview = underReview;
    }

    public int getQueued() {
      return queued;
    }

    public void setQueued(int queued) {
      this.queued = queued;
    }

    public int getProcessing() {
      return processing;
    }

    public void setProcessing(int processing) {
      this.processing = processing;
    }

  }

}
