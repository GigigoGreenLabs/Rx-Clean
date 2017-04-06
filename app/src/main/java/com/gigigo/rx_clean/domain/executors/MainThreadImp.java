package com.gigigo.rx_clean.domain.executors;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by rui.alonso on 6/4/17.
 */

public class MainThreadImp implements MainThread {
  private Handler handler;

  public MainThreadImp() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  @Override public void execute(Runnable runnable) {
    this.handler.post(runnable);
  }
}
