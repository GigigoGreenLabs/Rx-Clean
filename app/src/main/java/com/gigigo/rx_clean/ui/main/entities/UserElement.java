package com.gigigo.rx_clean.ui.main.entities;

/**
 * Created by rui.alonso on 31/10/16.
 */
public class UserElement {
  private String thumbnail;
  private String name;
  private String phone;
  private String location;

  public UserElement(String thumbnail, String name, String phone, String location) {
    this.thumbnail = thumbnail;
    this.name = name;
    this.phone = phone;
    this.location = location;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
