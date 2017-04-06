package com.gigigo.rx_clean.presentation.main;

import com.gigigo.rx_clean.domain.entities.Location;
import com.gigigo.rx_clean.domain.entities.Name;
import com.gigigo.rx_clean.domain.entities.Picture;
import com.gigigo.rx_clean.domain.entities.User;
import java.util.ArrayList;
import java.util.List;

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

    List<User> users = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      User user = new User();
      user.setName(new Name("Cristiano", "Ronaldo", "Dos Santos"));
      user.setPhone(new StringBuilder("666").append(i).toString());
      user.setLocation(new Location("Paseo de la Castellana", "Madrid", "Spain", 28080));
      user.setPicture(new Picture("", "",
          new StringBuilder("https://randomuser.me/api/portraits/thumb/men/").append(i)
              .append(".jpg")
              .toString()));

      users.add(user);
    }

    view.showUsers(users);

    view.hideLoading();
  }
}
