package com.gigigo.rx_clean.presentation.main;

/**
 * Created by rui.alonso on 4/4/17.
 */

public class MainPresenter {
  private MainView view;

  public MainPresenter() {

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

    view.showUsers();

    view.hideLoading();
  }
}
