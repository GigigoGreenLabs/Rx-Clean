package com.gigigo.rx_clean.di;

import android.content.Context;
import com.gigigo.rx_clean.data.datasources.UsersDataSourceImp;
import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.interactors.GetUsersInteractor;
import com.gigigo.rx_clean.presentation.main.MainPresenter;
import com.gigigo.ui.imageloader.ImageLoader;
import com.gigigo.ui.imageloader.glide.GlideImageLoaderImp;

/**
 * Created by rui.alonso on 6/4/17.
 */

public class Injector {
  public static ImageLoader provideImageLoader(Context context) {
    ImageLoader imageLoader = new GlideImageLoaderImp(context);
    return imageLoader;
  }

  public static MainPresenter provideMainPresenter() {
    GetUsersInteractor getUsersInteractor = provideGetUsersInteractor();
    MainPresenter presenter = new MainPresenter(getUsersInteractor);
    return presenter;
  }

  public static GetUsersInteractor provideGetUsersInteractor() {
    UsersDataSource usersDataSource = provideUsersDataSource();
    GetUsersInteractor getUsersInteractor = new GetUsersInteractor(usersDataSource);
    return getUsersInteractor;
  }

  public static UsersDataSource provideUsersDataSource() {
    UsersDataSource usersDataSource = new UsersDataSourceImp();
    return usersDataSource;
  }
}
