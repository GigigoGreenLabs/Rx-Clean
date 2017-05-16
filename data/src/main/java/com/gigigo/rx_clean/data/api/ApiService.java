package com.gigigo.rx_clean.data.api;

import com.gigigo.rx_clean.data.entities.ApiDataResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by rui.alonso on 6/4/17.
 */

public interface ApiService {

  @Headers("Content-Type: application/json")
  @GET(" ") Observable<ApiDataResponse> getUsers(@Query("results") int count);
}
