package com.gigigo.rx_clean.domain.executors;

import com.gigigo.rx_clean.domain.interactors.Interactor;

/**
 * Created by rui.alonso on 7/4/17.
 */

public interface InteractorExecutor {
  void run(final Interactor interactor);
}
