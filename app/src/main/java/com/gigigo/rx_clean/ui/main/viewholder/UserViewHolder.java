package com.gigigo.rx_clean.ui.main.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolder;
import com.gigigo.rx_clean.R;
import com.gigigo.rx_clean.ui.main.entities.UserElement;
import com.gigigo.ui.imageloader.ImageLoader;

public class UserViewHolder extends BaseViewHolder<UserElement> {

  private final ImageView userImage;
  private final TextView userNameText;
  private final TextView userPhoneText;
  private final TextView userLocationText;
  private ImageLoader imageLoader;

  public UserViewHolder(Context context, ViewGroup parent, ImageLoader imageLoader) {
    super(context, parent, R.layout.view_user_item);
    this.imageLoader = imageLoader;

    userImage = (ImageView) itemView.findViewById(R.id.user_image);
    userNameText = (TextView) itemView.findViewById(R.id.user_name);
    userPhoneText = (TextView) itemView.findViewById(R.id.user_phone);
    userLocationText = (TextView) itemView.findViewById(R.id.user_location);
  }

  @Override public void bindTo(UserElement value, int position) {
    //itemView.setId(value.getId());
    imageLoader.load(value.getThumbnail()).into(userImage).build();

    userNameText.setText(value.getName());
    userPhoneText.setText(value.getPhone());
    userLocationText.setText(value.getLocation());
  }
}
