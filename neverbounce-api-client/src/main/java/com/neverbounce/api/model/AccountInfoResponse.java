package com.neverbounce.api.model;

import com.google.api.client.util.Key;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class AccountInfoResponse extends BaseResponse {

  @Key("billing_type")
  private String billingType;

  @Key
  private int credits;

  @Key("free_api_credits")
  private int freeApiCredits;

  @Key("monthly_api_usage")
  private int monthlyApiUsage;

  @Key("monthly_dashboard_usage")
  private int monthlyDashboardUsage;

  @Key("jobs_completed")
  private int jobsCompleted;

  @Key("jobs_under_review")
  private int jobsUnderReview;

  @Key("jobs_queued")
  private int jobsQueued;

  @Key("jobs_processing")
  private int jobsProcessing;

  public String getBillingType() {
    return billingType;
  }

  public void setBillingType(String billingType) {
    this.billingType = billingType;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public int getFreeApiCredits() {
    return freeApiCredits;
  }

  public void setFreeApiCredits(int freeApiCredits) {
    this.freeApiCredits = freeApiCredits;
  }

  public int getMonthlyApiUsage() {
    return monthlyApiUsage;
  }

  public void setMonthlyApiUsage(int monthlyApiUsage) {
    this.monthlyApiUsage = monthlyApiUsage;
  }

  public int getMonthlyDashboardUsage() {
    return monthlyDashboardUsage;
  }

  public void setMonthlyDashboardUsage(int monthlyDashboardUsage) {
    this.monthlyDashboardUsage = monthlyDashboardUsage;
  }

  public int getJobsCompleted() {
    return jobsCompleted;
  }

  public void setJobsCompleted(int jobsCompleted) {
    this.jobsCompleted = jobsCompleted;
  }

  public int getJobsUnderReview() {
    return jobsUnderReview;
  }

  public void setJobsUnderReview(int jobsUnderReview) {
    this.jobsUnderReview = jobsUnderReview;
  }

  public int getJobsQueued() {
    return jobsQueued;
  }

  public void setJobsQueued(int jobsQueued) {
    this.jobsQueued = jobsQueued;
  }

  public int getJobsProcessing() {
    return jobsProcessing;
  }

  public void setJobsProcessing(int jobsProcessing) {
    this.jobsProcessing = jobsProcessing;
  }

}
