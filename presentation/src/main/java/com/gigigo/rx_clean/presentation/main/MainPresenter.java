package com.gigigo.rx_clean.presentation.main;

import com.gigigo.rx_clean.domain.entities.User;
import com.gigigo.rx_clean.domain.interactors.GetUserInteractorRx;
import com.gigigo.rx_clean.domain.interactors.GetUsersInteractor;
import com.gigigo.rx_clean.domain.interactors.InteractorCallback;
import com.gigigo.rx_clean.presentation.Presenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

/**
 * Created by rui.alonso on 4/4/17.
 */

public class MainPresenter implements Presenter {
  private MainView view;
  private GetUserInteractorRx getUsersInteractor;

  public MainPresenter(GetUserInteractorRx getUsersInteractor) {
    System.out.println("Presenter: " + Thread.currentThread().getName());

    this.getUsersInteractor = getUsersInteractor;



  //  this.getUsersInteractor.setCallback(new InteractorCallback<List<User>>() {
  //    @Override public void onSuccess(List<User> response) {
  //      System.out.println("Presenter callback: " + Thread.currentThread().getName());
  //
  //      view.showUsers(response);
  //      view.hideLoading();
  //    }
  //
  //    @Override public void onError(String message) {
  //      view.hideLoading();
  //    }
  //  });
  }

  public void attachView(MainView view) {
    this.view = view;
    onViewAttached();
  }

  public void detachView() {
    this.view = null;
  }

  public void onViewAttached() {
    view.initUi();
  }

  public void uiFinished() {
    loadData();
  }

  private void loadData() {
    view.showLoading();

    GetUserInteractorRx.Params params = GetUserInteractorRx.Params.count(100);

    GetUserObserver listGetUserObserver = new GetUserObserver();

    getUsersInteractor.execute(listGetUserObserver, params);
  }

  private class GetUserObserver extends DisposableObserver<List<User>> {

    @Override public void onNext(@NonNull List<User> response) {
      view.showUsers(response);
    }

    @Override public void onError(@NonNull Throwable e) {
      view.hideLoading();
    }

    @Override public void onComplete() {
      view.hideLoading();
    }
  }
}
