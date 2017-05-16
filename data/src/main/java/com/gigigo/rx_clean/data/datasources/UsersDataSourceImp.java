package com.gigigo.rx_clean.data.datasources;

import com.gigigo.rx_clean.data.api.ApiService;
import com.gigigo.rx_clean.data.entities.ApiDataResponse;
import com.gigigo.rx_clean.data.entities.ApiUser;
import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.entities.Location;
import com.gigigo.rx_clean.domain.entities.Name;
import com.gigigo.rx_clean.domain.entities.Picture;
import com.gigigo.rx_clean.domain.entities.User;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rui.alonso on 6/4/17.
 */

public class UsersDataSourceImp implements UsersDataSource {
  private ApiService apiService;

  public UsersDataSourceImp() {
    this.apiService = getApiService();
  }

  @Override public Observable<List<User>> getUsers(int count) {
    System.out.println("DataSource: " + Thread.currentThread().getName());
    
    return apiService.getUsers(count).map(new Function<ApiDataResponse, List<User>>() {
      @Override public List<User> apply(ApiDataResponse apiDataResponse) throws Exception {
        return mapApiModelToDomain(apiDataResponse.getApiUsers());
      }
    });
  }

  private List<User> mapApiModelToDomain(List<ApiUser> apiUsers) {
    List<User> users = new ArrayList<>();

    for (ApiUser apiUser : apiUsers) {
      User user = new User();
      user.setName(new Name(apiUser.getApiName().getTitle(), apiUser.getApiName().getFirst(),
          apiUser.getApiName().getLast()));
      user.setPhone(apiUser.getPhone());
      user.setLocation(
          new Location(apiUser.getApiLocation().getStreet(), apiUser.getApiLocation().getCity(),
              apiUser.getApiLocation().getState(), apiUser.getApiLocation().getPostcode()));
      user.setPicture(
          new Picture(apiUser.getApiPicture().getLarge(), apiUser.getApiPicture().getMedium(),
              apiUser.getApiPicture().getThumbnail()));
      users.add(user);
    }

    return users;
  }

  private ApiService getApiService() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://randomuser.me/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    return retrofit.create(ApiService.class);
  }
}
