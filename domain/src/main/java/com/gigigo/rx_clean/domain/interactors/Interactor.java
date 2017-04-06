package com.gigigo.rx_clean.domain.interactors;

import com.gigigo.rx_clean.domain.executors.MainThread;

/**
 * Created by rui.alonso on 6/4/17.
 */

public abstract class Interactor<T> implements Runnable {
  protected InteractorCallback<T> callback;
  protected MainThread mainThread;

  public abstract void execute();

  public void setCallback(InteractorCallback<T> callback) {
    this.callback = callback;
  }

  protected void notifySuccess(final T response) {
    mainThread.execute(new Runnable() {
      @Override public void run() {
        callback.onSuccess(response);
      }
    });
  }

  protected void notifyError(final Throwable error) {
    mainThread.execute(new Runnable() {
      @Override public void run() {
        callback.onError(error.getMessage());
      }
    });
  }
}
