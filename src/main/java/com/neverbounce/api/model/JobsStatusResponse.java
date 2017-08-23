package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import com.neverbounce.api.internal.DateUtils;
import java.util.Date;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 * @see <a href="https://developers.neverbounce.com/v4.0/reference#jobs-status">Jobs Status</a>
 */
public class JobsStatusResponse extends GenericResponse {

  @Key
  private long id;

  @Key
  private String filename;

  @Key("created_at")
  private String createdAtAsString;

  @Key("started_at")
  private String startedAtAsString;

  @Key("finished_at")
  private String finishedAtAsString;

  @Key
  private Total total;

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

  public Date getCreatedAt() {
    return DateUtils.toDate(createdAtAsString);
  }

  public String getCreatedAtAsString() {
    return createdAtAsString;
  }

  public void setCreatedAtAsString(String createdAtAsString) {
    this.createdAtAsString = createdAtAsString;
  }

  public Date getStartedAt() {
    return DateUtils.toDate(startedAtAsString);
  }

  public String getStartedAtAsString() {
    return startedAtAsString;
  }

  public Date getFinishedAt() {
    return DateUtils.toDate(finishedAtAsString);
  }

  public String getFinishedAtAsString() {
    return finishedAtAsString;
  }

  public Total getTotal() {
    return total;
  }

  public void setTotal(Total total) {
    this.total = total;
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

  public static class Total {

    @Key("records")
    private int records;

    @Key("billable")
    private int billable;

    @Key("processed")
    private int processed;

    @Key("valid")
    private int valid;

    @Key("invalid")
    private int invalid;

    @Key("catchall")
    private int catchall;

    @Key("disposable")
    private int disposable;

    @Key("unknown")
    private int unknown;

    @Key("duplicates")
    private int duplicates;

    @Key("bad_syntax")
    private int badSyntax;

    public int getRecords() {
      return records;
    }

    public void setRecords(int records) {
      this.records = records;
    }

    public int getBillable() {
      return billable;
    }

    public void setBillable(int billable) {
      this.billable = billable;
    }

    public int getProcessed() {
      return processed;
    }

    public void setProcessed(int processed) {
      this.processed = processed;
    }

    public int getValid() {
      return valid;
    }

    public void setValid(int valid) {
      this.valid = valid;
    }

    public int getInvalid() {
      return invalid;
    }

    public void setInvalid(int invalid) {
      this.invalid = invalid;
    }

    public int getCatchall() {
      return catchall;
    }

    public void setCatchall(int catchall) {
      this.catchall = catchall;
    }

    public int getDisposable() {
      return disposable;
    }

    public void setDisposable(int disposable) {
      this.disposable = disposable;
    }

    public int getUnknown() {
      return unknown;
    }

    public void setUnknown(int unknown) {
      this.unknown = unknown;
    }

    public int getDuplicates() {
      return duplicates;
    }

    public void setDuplicates(int duplicates) {
      this.duplicates = duplicates;
    }

    public int getBadSyntax() {
      return badSyntax;
    }

    public void setBadSyntax(int badSyntax) {
      this.badSyntax = badSyntax;
    }

  }

}
