package com.gigigo.rx_clean.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiDataResponse {

  @SerializedName("results") @Expose private List<ApiResult> apiResults = null;
  @SerializedName("info") @Expose private ApiInfo apiInfo;

  public ApiDataResponse() {
  }

  public ApiDataResponse(List<ApiResult> apiResults, ApiInfo apiInfo) {
    super();
    this.apiResults = apiResults;
    this.apiInfo = apiInfo;
  }

  public List<ApiResult> getApiResults() {
    return apiResults;
  }

  public void setApiResults(List<ApiResult> apiResults) {
    this.apiResults = apiResults;
  }

  public ApiInfo getApiInfo() {
    return apiInfo;
  }

  public void setApiInfo(ApiInfo apiInfo) {
    this.apiInfo = apiInfo;
  }
}
