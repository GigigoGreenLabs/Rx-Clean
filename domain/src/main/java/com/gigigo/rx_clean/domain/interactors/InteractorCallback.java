package com.gigigo.rx_clean.domain.interactors;

/**
 * Created by rui.alonso on 6/4/17.
 */

public interface InteractorCallback<T> {
  void onSuccess(T response);

  void onError(String message);
}
