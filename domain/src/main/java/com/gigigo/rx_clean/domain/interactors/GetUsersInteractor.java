package com.gigigo.rx_clean.domain.interactors;

import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.entities.User;
import java.util.List;

/**
 * Created by rui.alonso on 6/4/17.
 */

public class GetUsersInteractor implements Interactor<List<User>> {

  private UsersDataSource usersDataSource;

  public GetUsersInteractor(UsersDataSource usersDataSource) {
    this.usersDataSource = usersDataSource;
  }

  @Override public List<User> execute() {
    List<User> users = usersDataSource.getUsers(500);
    return users;
  }
}
