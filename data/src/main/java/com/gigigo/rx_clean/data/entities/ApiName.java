package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiName {

  @SerializedName("title") @Expose private String title;
  @SerializedName("first") @Expose private String first;
  @SerializedName("last") @Expose private String last;

  public ApiName() {
  }

  public ApiName(String title, String first, String last) {
    super();
    this.title = title;
    this.first = first;
    this.last = last;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }
}
