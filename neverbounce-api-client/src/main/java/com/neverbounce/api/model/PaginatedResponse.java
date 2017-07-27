package com.neverbounce.api.model;

import com.google.api.client.util.Key;
import java.util.List;

/**
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class PaginatedResponse<T> extends GenericResponse {

  @Key("total_results")
  private int totalResults;

  @Key("total_pages")
  private int totalPages;

  @Key
  private Query query;

  @Key
  private List<T> results;

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public Query getQuery() {
    return query;
  }

  public void setQuery(Query query) {
    this.query = query;
  }

  public List<T> getResults() {
    return results;
  }

  public void setResults(List<T> results) {
    this.results = results;
  }

  public boolean hasNext() {
    return query.page < totalPages;
  }

  public static class Query {

    @Key("job_id")
    private long jobId;

    @Key
    private int valids;

    @Key
    private int invalids;

    @Key
    private int disposables;

    @Key
    private int catchalls;

    @Key
    private int unknowns;

    @Key
    private int page;

    @Key("items_per_page")
    private int itemsPerPage;

    public long getJobId() {
      return jobId;
    }

    public void setJobId(long jobId) {
      this.jobId = jobId;
    }

    public int getValids() {
      return valids;
    }

    public void setValids(int valids) {
      this.valids = valids;
    }

    public int getInvalids() {
      return invalids;
    }

    public void setInvalids(int invalids) {
      this.invalids = invalids;
    }

    public int getDisposables() {
      return disposables;
    }

    public void setDisposables(int disposables) {
      this.disposables = disposables;
    }

    public int getCatchalls() {
      return catchalls;
    }

    public void setCatchalls(int catchalls) {
      this.catchalls = catchalls;
    }

    public int getUnknowns() {
      return unknowns;
    }

    public void setUnknowns(int unknowns) {
      this.unknowns = unknowns;
    }

    public int getPage() {
      return page;
    }

    public void setPage(int page) {
      this.page = page;
    }

    public int getItemsPerPage() {
      return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
      this.itemsPerPage = itemsPerPage;
    }

  }

}
