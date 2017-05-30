package com.gigigo.rx_clean.di;

import android.content.Context;
import com.gigigo.rx_clean.data.datasources.UsersDataSourceImp;
import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.executors.ThreadExecutor;
import com.gigigo.rx_clean.domain.executors.MainThread;
import com.gigigo.rx_clean.domain.executors.MainThreadImp;
import com.gigigo.rx_clean.domain.executors.JobExecutor;
import com.gigigo.rx_clean.domain.interactors.GetUserInteractorRx;
import com.gigigo.rx_clean.domain.interactors.GetUsersInteractor;
import com.gigigo.rx_clean.presentation.main.MainPresenter;
import com.gigigo.ui.imageloader.ImageLoader;
import com.gigigo.ui.imageloader.glide.GlideImageLoaderImp;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rui.alonso on 6/4/17.
 */

public class Injector {
  public static ImageLoader provideImageLoader(Context context) {
    ImageLoader imageLoader = new GlideImageLoaderImp(context);
    return imageLoader;
  }

  public static MainPresenter provideMainPresenter() {
    GetUserInteractorRx getUsersInteractor = provideGetUsersInteractorRx();
    MainPresenter presenter = new MainPresenter(getUsersInteractor);
    return presenter;
  }

  public static MainThread provideMainThread() {
    return new MainThreadImp();
  }

  //public static GetUsersInteractor provideGetUsersInteractor() {
  //  UsersDataSource usersDataSource = provideUsersDataSource();
  //  ThreadExecutor threadExecutor = new JobExecutor();
  //  MainThread mainThread = provideMainThread();
  //  GetUsersInteractor getUsersInteractor = new GetUsersInteractor(usersDataSource, threadExecutor, mainThread);
  //  return getUsersInteractor;
  //}

  public static GetUserInteractorRx provideGetUsersInteractorRx() {
    UsersDataSource usersDataSource = provideUsersDataSource();
    return new GetUserInteractorRx(usersDataSource, AndroidSchedulers.mainThread(), Schedulers.io());
  }

  public static UsersDataSource provideUsersDataSource() {
    UsersDataSource usersDataSource = new UsersDataSourceImp();
    return usersDataSource;
  }
}
