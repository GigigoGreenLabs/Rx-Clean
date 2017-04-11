package com.gigigo.rx_clean.domain.interactors;

import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.entities.User;
import com.gigigo.rx_clean.domain.executors.ThreadExecutor;
import com.gigigo.rx_clean.domain.executors.MainThread;
import java.util.List;

/**
 * Created by rui.alonso on 6/4/17.
 */

public class GetUsersInteractor extends Interactor<List<User>> {
  private UsersDataSource usersDataSource;

  public GetUsersInteractor(UsersDataSource usersDataSource, ThreadExecutor threadExecutor, MainThread mainThread) {
    this.usersDataSource = usersDataSource;
    this.threadExecutor = threadExecutor;
    this.mainThread = mainThread;
  }

  @Override public void run() {
    try {
      System.out.println("Interactor: " + Thread.currentThread().getName());
      List<User> users = usersDataSource.getUsers(500);
      notifySuccess(users);
    } catch (Exception e) {
      notifyError(e);
    }
  }
}
