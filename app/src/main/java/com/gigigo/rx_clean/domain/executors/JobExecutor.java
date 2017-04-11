package com.gigigo.rx_clean.domain.executors;

import android.support.annotation.NonNull;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by rui.alonso on 7/4/17.
 */

public class JobExecutor implements ThreadExecutor {
  public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
  private final int CORE_POOL_SIZE = NUMBER_OF_CORES * 2;
  private final int MAX_POOL_SIZE = NUMBER_OF_CORES * 2;
  private final long KEEP_ALIVE_TIME = 60L;
  private ThreadPoolExecutor threadPoolExecutor;

  public JobExecutor() {
    this.threadPoolExecutor =
        new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(), new JobThreadFactory());
  }

  @Override public void execute(@NonNull Runnable command) {
    if (threadPoolExecutor != null) {
      threadPoolExecutor.execute(command);
    }
  }

  private static class JobThreadFactory implements ThreadFactory {
    private int counter = 0;

    @Override public Thread newThread(@NonNull Runnable runnable) {
      return new Thread(runnable, "android_thread_" + counter++);
    }
  }
}
