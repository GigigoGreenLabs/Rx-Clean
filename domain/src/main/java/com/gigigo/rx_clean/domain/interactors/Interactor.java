package com.gigigo.rx_clean.domain.interactors;

import com.gigigo.rx_clean.domain.executors.MainThread;
import com.gigigo.rx_clean.domain.executors.ThreadExecutor;

/**
 * Created by rui.alonso on 6/4/17.
 */

public abstract class Interactor<T> implements Runnable {
  protected InteractorCallback<T> callback;
  protected ThreadExecutor threadExecutor;
  protected MainThread mainThread;
  public Thread callbackThread;

  public void execute() {
    callbackThread = Thread.currentThread();
    threadExecutor.execute(this);
  }

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
