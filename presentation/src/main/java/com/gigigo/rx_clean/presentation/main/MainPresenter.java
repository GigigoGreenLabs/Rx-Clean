package com.gigigo.rx_clean.presentation.main;

import com.gigigo.rx_clean.domain.entities.User;
import com.gigigo.rx_clean.domain.interactors.GetUsersInteractor;
import com.gigigo.rx_clean.domain.interactors.InteractorCallback;
import com.gigigo.rx_clean.presentation.Presenter;
import java.util.List;

/**
 * Created by rui.alonso on 4/4/17.
 */

public class MainPresenter implements Presenter {
  private MainView view;
  private GetUsersInteractor getUsersInteractor;

  public MainPresenter(GetUsersInteractor getUsersInteractor) {
    System.out.println("Presenter: " + Thread.currentThread().getName());

    this.getUsersInteractor = getUsersInteractor;
    this.getUsersInteractor.setCallback(new InteractorCallback<List<User>>() {
      @Override public void onSuccess(List<User> response) {
        System.out.println("Presenter callback: " + Thread.currentThread().getName());

        view.showUsers(response);
        view.hideLoading();
      }

      @Override public void onError(String message) {
        view.hideLoading();
      }
    });
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
    getUsersInteractor.execute();
  }
}
