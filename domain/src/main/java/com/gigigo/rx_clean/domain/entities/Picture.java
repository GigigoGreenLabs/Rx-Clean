package com.gigigo.rx_clean.domain.entities;

public class Picture {

  private String large;
  private String medium;
  private String thumbnail;

  public Picture() {
  }

  public Picture(String large, String medium, String thumbnail) {
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
