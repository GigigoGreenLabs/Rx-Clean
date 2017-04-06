package com.gigigo.rx_clean.domain.entities;

public class Info {

  private String seed;
  private long results;
  private long page;
  private String version;

  public Info() {
  }

  public Info(String seed, long results, long page, String version) {
    super();
    this.seed = seed;
    this.results = results;
    this.page = page;
    this.version = version;
  }

  public String getSeed() {
    return seed;
  }

  public void setSeed(String seed) {
    this.seed = seed;
  }

  public long getResults() {
    return results;
  }

  public void setResults(long results) {
    this.results = results;
  }

  public long getPage() {
    return page;
  }

  public void setPage(long page) {
    this.page = page;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}
