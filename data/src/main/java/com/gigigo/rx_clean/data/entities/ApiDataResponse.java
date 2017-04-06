package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiDataResponse {

  @SerializedName("results") @Expose private List<ApiUser> apiUsers = null;
  @SerializedName("info") @Expose private ApiInfo apiInfo;

  public ApiDataResponse() {
  }

  public ApiDataResponse(List<ApiUser> apiUsers, ApiInfo apiInfo) {
    super();
    this.apiUsers = apiUsers;
    this.apiInfo = apiInfo;
  }

  public List<ApiUser> getApiUsers() {
    return apiUsers;
  }

  public void setApiUsers(List<ApiUser> apiUsers) {
    this.apiUsers = apiUsers;
  }

  public ApiInfo getApiInfo() {
    return apiInfo;
  }

  public void setApiInfo(ApiInfo apiInfo) {
    this.apiInfo = apiInfo;
  }
}
