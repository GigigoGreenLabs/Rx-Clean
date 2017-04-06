package com.gigigo.rx_clean.domain.executors;

/**
 * Created by rui.alonso on 6/4/17.
 */

public interface MainThread {
  void execute(Runnable runnable);
}
