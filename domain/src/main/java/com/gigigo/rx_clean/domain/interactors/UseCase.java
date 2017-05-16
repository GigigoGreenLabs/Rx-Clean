package com.gigigo.rx_clean.domain.interactors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public abstract class UseCase<Model, Params> {

  private final Scheduler scheduler;
  private final Scheduler postExecutionScheduler;

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  protected UseCase(Scheduler scheduler,
      Scheduler postExecutionScheduler) {
    this.scheduler = scheduler;
    this.postExecutionScheduler = postExecutionScheduler;
  }

  public void execute(DisposableObserver<Model> useCaseSubscriber, Params params) {
    final Observable<Model> observable = buildObservable(params)
        .subscribeOn(postExecutionScheduler)
        .observeOn(scheduler);
    compositeDisposable.add(observable.subscribeWith(useCaseSubscriber));
  }

  public void dispose() {
    if (!compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
  }

  protected abstract Observable<Model> buildObservable(Params params);
}
