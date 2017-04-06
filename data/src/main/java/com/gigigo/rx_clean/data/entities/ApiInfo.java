package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiInfo {

  @SerializedName("seed") @Expose private String seed;
  @SerializedName("results") @Expose private long results;
  @SerializedName("page") @Expose private long page;
  @SerializedName("version") @Expose private String version;

  public ApiInfo() {
  }

  public ApiInfo(String seed, long results, long page, String version) {
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
