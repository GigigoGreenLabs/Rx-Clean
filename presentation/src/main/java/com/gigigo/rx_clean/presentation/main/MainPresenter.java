package com.gigigo.rx_clean.presentation.main;

import com.gigigo.rx_clean.domain.entities.User;
import com.gigigo.rx_clean.domain.interactors.GetUsersInteractor;
import com.gigigo.rx_clean.presentation.Presenter;
import java.util.List;

/**
 * Created by rui.alonso on 4/4/17.
 */

public class MainPresenter implements Presenter {
  private MainView view;
  private GetUsersInteractor getUsersInteractor;

  public MainPresenter(GetUsersInteractor getUsersInteractor) {
    this.getUsersInteractor = getUsersInteractor;
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

    List<User> users = getUsersInteractor.execute();

    view.showUsers(users);

    view.hideLoading();
  }
}
