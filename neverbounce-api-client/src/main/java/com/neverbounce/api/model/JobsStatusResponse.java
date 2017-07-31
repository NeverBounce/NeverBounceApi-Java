package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.neverbounce.api.internal.DateUtils;
import java.util.Date;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class JobsStatusResponse extends GenericResponse {

  @Key
  private long id;

  @Key
  private String filename;

  @Key("created")
  private String createdAsString;

  @Key("started")
  private String startedAsString;

  @Key("finished")
  private String finishedAsString;

  @Key("total_records")
  private int totalRecords;

  @Key("total_billable")
  private int totalBillable;

  @Key("total_processed")
  private int totalProcessed;

  @Key("total_valid")
  private int totalValid;

  @Key("total_invalid")
  private int totalInvalid;

  @Key("total_catchall")
  private int totalCatchall;

  @Key("total_disposable")
  private int totalDisposable;

  @Key("total_unknown")
  private int totalUnknown;

  @Key("total_duplicates")
  private int totalDuplicates;

  @Key("total_bad_syntax")
  private int totalBadSyntax;

  @Key("bounce_estimate")
  private double bounceEstimate;

  @Key("percent_complete")
  private int percentComplete;

  @Key("job_status")
  private JobStatus jobStatus;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public Date getCreated() {
    return DateUtils.toDate(createdAsString);
  }

  public String getCreatedAsString() {
    return createdAsString;
  }

  public void setCreatedAsString(String createdAsString) {
    this.createdAsString = createdAsString;
  }

  public Date getStarted() {
    return DateUtils.toDate(startedAsString);
  }

  public String getStartedAsString() {
    return startedAsString;
  }

  public Date getFinished() {
    return DateUtils.toDate(finishedAsString);
  }

  public String getFinishedAsString() {
    return finishedAsString;
  }

  public int getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(int totalRecords) {
    this.totalRecords = totalRecords;
  }

  public int getTotalBillable() {
    return totalBillable;
  }

  public void setTotalBillable(int totalBillable) {
    this.totalBillable = totalBillable;
  }

  public int getTotalProcessed() {
    return totalProcessed;
  }

  public void setTotalProcessed(int totalProcessed) {
    this.totalProcessed = totalProcessed;
  }

  public int getTotalValid() {
    return totalValid;
  }

  public void setTotalValid(int totalValid) {
    this.totalValid = totalValid;
  }

  public int getTotalInvalid() {
    return totalInvalid;
  }

  public void setTotalInvalid(int totalInvalid) {
    this.totalInvalid = totalInvalid;
  }

  public int getTotalCatchall() {
    return totalCatchall;
  }

  public void setTotalCatchall(int totalCatchall) {
    this.totalCatchall = totalCatchall;
  }

  public int getTotalDisposable() {
    return totalDisposable;
  }

  public void setTotalDisposable(int totalDisposable) {
    this.totalDisposable = totalDisposable;
  }

  public int getTotalUnknown() {
    return totalUnknown;
  }

  public void setTotalUnknown(int totalUnknown) {
    this.totalUnknown = totalUnknown;
  }

  public int getTotalDuplicates() {
    return totalDuplicates;
  }

  public void setTotalDuplicates(int totalDuplicates) {
    this.totalDuplicates = totalDuplicates;
  }

  public int getTotalBadSyntax() {
    return totalBadSyntax;
  }

  public void setTotalBadSyntax(int totalBadSyntax) {
    this.totalBadSyntax = totalBadSyntax;
  }

  public double getBounceEstimate() {
    return bounceEstimate;
  }

  public void setBounceEstimate(double bounceEstimate) {
    this.bounceEstimate = bounceEstimate;
  }

  public int getPercentComplete() {
    return percentComplete;
  }

  public void setPercentComplete(int percentComplete) {
    this.percentComplete = percentComplete;
  }

  public JobStatus getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(JobStatus jobStatus) {
    this.jobStatus = jobStatus;
  }

}
