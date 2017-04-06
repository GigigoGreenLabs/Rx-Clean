package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPicture {

  @SerializedName("large") @Expose private String large;
  @SerializedName("medium") @Expose private String medium;
  @SerializedName("thumbnail") @Expose private String thumbnail;

  public ApiPicture() {
  }

  public ApiPicture(String large, String medium, String thumbnail) {
    super();
    this.large = large;
    this.medium = medium;
    this.thumbnail = thumbnail;
  }

  public String getLarge() {
    return large;
  }

  public void setLarge(String large) {
    this.large = large;
  }

  public String getMedium() {
    return medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
}
