package com.gigigo.rx_clean.data.datasources;

import com.gigigo.rx_clean.data.api.ApiService;
import com.gigigo.rx_clean.data.entities.ApiDataResponse;
import com.gigigo.rx_clean.data.entities.ApiUser;
import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.entities.Name;
import com.gigigo.rx_clean.domain.entities.Picture;
import com.gigigo.rx_clean.domain.entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

  @Override public List<User> getUsers(int count) {
    Response<ApiDataResponse> dataResponse;
    try {
      dataResponse = apiService.getUsers(count).execute();
      List<User> users = mapApiModelToDomain(dataResponse.body().getApiUsers());
      return users;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  private List<User> mapApiModelToDomain(List<ApiUser> apiUsers) {
    List<User> users = new ArrayList<>();

    for (ApiUser apiUser : apiUsers) {
      User user = new User();
      user.setName(new Name(apiUser.getApiName().getTitle(), apiUser.getApiName().getFirst(),
          apiUser.getApiName().getLast()));
      user.setPhone(apiUser.getPhone());
      user.setPicture(
          new Picture(apiUser.getApiPicture().getLarge(), apiUser.getApiPicture().getMedium(),
              apiUser.getApiPicture().getThumbnail()));
      users.add(user);
    }

    return users;
  }

  private ApiService getApiService() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://randomuser.me/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    return retrofit.create(ApiService.class);
  }
}
