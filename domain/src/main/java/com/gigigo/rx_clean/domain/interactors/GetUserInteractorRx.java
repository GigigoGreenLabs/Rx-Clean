package com.gigigo.rx_clean.domain.interactors;

import com.gigigo.rx_clean.domain.datasources.UsersDataSource;
import com.gigigo.rx_clean.domain.entities.User;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Comparator;
import java.util.List;

public class GetUserInteractorRx extends UseCase<List<User>, GetUserInteractorRx.Params>{

private final UsersDataSource usersDataSource;

  public GetUserInteractorRx(UsersDataSource usersDataSource,Scheduler scheduler,Scheduler postExecutionScheduler){
    super(scheduler,postExecutionScheduler);
    this.usersDataSource=usersDataSource;
  }

  @Override protected Observable<List<User>> buildObservable(GetUserInteractorRx.Params params){
    return usersDataSource.getUsers(params.count).flatMap(
        new Function<List<User>, Observable<User>>() {
      @Override public Observable<User> apply(@NonNull List<User> users) throws Exception {
        return Observable.fromIterable(users);
      }
    }).filter(new Predicate<User>() {
      @Override public boolean test(@NonNull User user) throws Exception {
        return user.getName().getTitle().equals("mr");
      }
    }).toSortedList(new Comparator<User>() {
      @Override public int compare(User user, User user1) {
        return user.getName().getTitle().compareTo(user1.getName().getTitle());
      }
    }).toObservable();
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
