package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiId {

  @SerializedName("name") @Expose private String name;
  @SerializedName("value") @Expose private Object value;

  public ApiId() {
  }

  public ApiId(String name, Object value) {
    super();
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }
}
