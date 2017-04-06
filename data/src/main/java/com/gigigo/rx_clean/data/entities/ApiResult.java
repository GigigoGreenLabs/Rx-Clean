package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResult {

  @SerializedName("gender") @Expose private String gender;
  @SerializedName("name") @Expose private ApiName apiName;
  @SerializedName("location") @Expose private ApiLocation apiLocation;
  @SerializedName("email") @Expose private String email;
  @SerializedName("login") @Expose private ApiLogin apiLogin;
  @SerializedName("dob") @Expose private String dob;
  @SerializedName("registered") @Expose private String registered;
  @SerializedName("phone") @Expose private String phone;
  @SerializedName("cell") @Expose private String cell;
  @SerializedName("id") @Expose private ApiId apiId;
  @SerializedName("picture") @Expose private ApiPicture apiPicture;
  @SerializedName("nat") @Expose private String nat;

  public ApiResult() {
  }

  public ApiResult(String gender, ApiName apiName, ApiLocation apiLocation, String email,
      ApiLogin apiLogin, String dob, String registered, String phone, String cell, ApiId apiId,
      ApiPicture apiPicture, String nat) {
    super();
    this.gender = gender;
    this.apiName = apiName;
    this.apiLocation = apiLocation;
    this.email = email;
    this.apiLogin = apiLogin;
    this.dob = dob;
    this.registered = registered;
    this.phone = phone;
    this.cell = cell;
    this.apiId = apiId;
    this.apiPicture = apiPicture;
    this.nat = nat;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public ApiName getApiName() {
    return apiName;
  }

  public void setApiName(ApiName apiName) {
    this.apiName = apiName;
  }

  public ApiLocation getApiLocation() {
    return apiLocation;
  }

  public void setApiLocation(ApiLocation apiLocation) {
    this.apiLocation = apiLocation;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ApiLogin getApiLogin() {
    return apiLogin;
  }

  public void setApiLogin(ApiLogin apiLogin) {
    this.apiLogin = apiLogin;
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

  public ApiId getApiId() {
    return apiId;
  }

  public void setApiId(ApiId apiId) {
    this.apiId = apiId;
  }

  public ApiPicture getApiPicture() {
    return apiPicture;
  }

  public void setApiPicture(ApiPicture apiPicture) {
    this.apiPicture = apiPicture;
  }

  public String getNat() {
    return nat;
  }

  public void setNat(String nat) {
    this.nat = nat;
  }
}
