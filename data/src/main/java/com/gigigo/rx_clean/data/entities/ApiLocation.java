package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiLocation {

  @SerializedName("street") @Expose private String street;
  @SerializedName("city") @Expose private String city;
  @SerializedName("state") @Expose private String state;
  @SerializedName("postcode") @Expose private String postcode;

  public ApiLocation() {
  }

  public ApiLocation(String street, String city, String state, String postcode) {
    super();
    this.street = street;
    this.city = city;
    this.state = state;
    this.postcode = postcode;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }
}
