package com.gigigo.rx_clean.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import com.gigigo.baserecycleradapter.adapter.BaseRecyclerAdapter;
import com.gigigo.baserecycleradapter.viewholder.BaseViewHolderFactory;
import com.gigigo.rx_clean.R;
import com.gigigo.rx_clean.presentation.main.MainPresenter;
import com.gigigo.rx_clean.presentation.main.MainView;
import com.gigigo.rx_clean.ui.main.entities.UserElement;
import com.gigigo.rx_clean.ui.main.factory.UserViewHolderFactory;
import com.gigigo.rx_clean.ui.main.viewholder.UserViewHolder;
import com.gigigo.ui.imageloader.ImageLoader;
import com.gigigo.ui.imageloader.glide.GlideImageLoaderImp;

public class MainActivity extends AppCompatActivity implements MainView {

  private ProgressBar loadingProgress;
  private RecyclerView usersRecyclerView;
  private BaseRecyclerAdapter usersAdapter;

  private MainPresenter presenter;
  private ImageLoader imageLoader;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initDI();
  }

  private void initDI() {
    imageLoader = new GlideImageLoaderImp(this);
    presenter = new MainPresenter();
  }

  @Override public void initUi() {
    initView();
    presenter.uiFinished();
  }

  private void initView() {
    loadingProgress = (ProgressBar) findViewById(R.id.loading_progress);

    initAdapter();
    initRecyclerView();
  }

  private void initRecyclerView() {
    usersRecyclerView = (RecyclerView) findViewById(R.id.user_recycler);
    usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    usersRecyclerView.setHasFixedSize(true);
    usersRecyclerView.setAdapter(usersAdapter);
  }

  private void initAdapter() {
    BaseViewHolderFactory baseViewHolderFactory = new UserViewHolderFactory(this, imageLoader);
    usersAdapter = new BaseRecyclerAdapter(baseViewHolderFactory);
    usersAdapter.bind(UserElement.class, UserViewHolder.class);
  }

  @Override public void showLoading() {
    loadingProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    loadingProgress.setVisibility(View.INVISIBLE);
  }

  @Override public void showUsers() {

  }

  @Override protected void onStart() {
    super.onStart();
    presenter.attachView(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }
}
