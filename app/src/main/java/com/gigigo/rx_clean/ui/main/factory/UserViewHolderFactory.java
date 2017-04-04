package com.gigigo.rx_clean.ui.main.factory;

import android.content.Context;
import android.view.ViewGroup;
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolder;
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolderFactory;
import com.gigigo.rx_clean.ui.main.entities.UserElement;
import com.gigigo.rx_clean.ui.main.viewholder.UserViewHolder;
import com.gigigo.ui.imageloader.ImageLoader;

/**
 * Created by rui.alonso on 2/2/17.
 */
public class UserViewHolderFactory extends BaseViewHolderFactory {
  private final ImageLoader imageLoader;

  public UserViewHolderFactory(Context context, ImageLoader imageLoader) {
    super(context);
    this.imageLoader = imageLoader;
  }

  @Override public BaseViewHolder create(Class valueClass, ViewGroup parent) {
    if (valueClass == UserElement.class) {
      return new UserViewHolder(context, parent, imageLoader);
    } else {
      return null;
    }
  }
}
