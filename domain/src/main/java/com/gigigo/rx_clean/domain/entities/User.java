package com.gigigo.rx_clean.domain.entities;

public class User {

  private String gender;
  private Name name;
  private Location location;
  private String email;
  private Login login;
  private String dob;
  private String registered;
  private String phone;
  private String cell;
  private Id id;
  private Picture picture;
  private String nat;

  public User() {
  }

  public User(String gender, Name name, Location location, String email, Login login, String dob,
      String registered, String phone, String cell, Id id, Picture picture, String nat) {
    this.gender = gender;
    this.name = name;
    this.location = location;
    this.email = email;
    this.login = login;
    this.dob = dob;
    this.registered = registered;
    this.phone = phone;
    this.cell = cell;
    this.id = id;
    this.picture = picture;
    this.nat = nat;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Login getLogin() {
    return login;
  }

  public void setLogin(Login login) {
    this.login = login;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getRegistered() {
    return registered;
  }

  public void setRegistered(String registered) {
    this.registered = registered;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCell() {
    return cell;
  }

  public void setCell(String cell) {
    this.cell = cell;
  }

  public Id getId() {
    return id;
  }

  public void setId(Id id) {
    this.id = id;
  }

  public Picture getPicture() {
    return picture;
  }

  public void setPicture(Picture picture) {
    this.picture = picture;
  }

  public String getNat() {
    return nat;
  }

  public void setNat(String nat) {
    this.nat = nat;
  }
}
