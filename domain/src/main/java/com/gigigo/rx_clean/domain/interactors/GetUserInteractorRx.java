package com.gigigo.rx_clean.domain.interactors;

import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.entities.User;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;

public class GetUserInteractorRx extends UseCase<List<User>, GetUserInteractorRx.Params>{

private final UsersDataSource usersDataSource;

  public GetUserInteractorRx(UsersDataSource usersDataSource,Scheduler scheduler,Scheduler postExecutionScheduler){
    super(scheduler,postExecutionScheduler);
    this.usersDataSource=usersDataSource;
  }

  @Override protected Observable<List<User>> buildObservable(GetUserInteractorRx.Params params){
    return usersDataSource.getUsers(params.count);
  }

  public static class Params {

    private final int count;

    private Params(int count) {
      this.count = count;
    }

    public static Params count(int count) {
      return new Params(count);
    }
  }
}
