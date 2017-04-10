package com.gigigo.rx_clean.domain.executors;

import com.gigigo.rx_clean.domain.interactors.Interactor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by rui.alonso on 7/4/17.
 */

public class ThreadExecutor implements InteractorExecutor {
  public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

  private ThreadPoolExecutor threadPoolExecutor;

  public ThreadExecutor() {
    this.threadPoolExecutor =
        new ThreadPoolExecutor(NUMBER_OF_CORES * 2, NUMBER_OF_CORES * 2, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());
  }

  @Override public void run(Interactor interactor) {
    if (threadPoolExecutor != null) {
      threadPoolExecutor.submit(interactor);
    }
  }
}
