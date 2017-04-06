package com.gigigo.rx_clean.domain.entities;

public class Location {

  private String street;
  private String city;
  private String state;
  private long postcode;

  public Location() {
  }

  public Location(String street, String city, String state, long postcode) {
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

  public long getPostcode() {
    return postcode;
  }

  public void setPostcode(long postcode) {
    this.postcode = postcode;
  }
}
