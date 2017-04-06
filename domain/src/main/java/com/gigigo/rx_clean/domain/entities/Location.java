package com.gigigo.rx_clean.domain.entities;

public class Location {

  private String street;
  private String city;
  private String state;
  private String postcode;

  public Location() {
  }

  public Location(String street, String city, String state, String postcode) {
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
