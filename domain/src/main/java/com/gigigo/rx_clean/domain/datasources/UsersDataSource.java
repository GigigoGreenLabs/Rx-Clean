package com.gigigo.rx_clean.domain.datasources;

import com.gigigo.rx_clean.domain.entities.User;
import java.util.List;

/**
 * Created by rui.alonso on 6/4/17.
 */

public interface UsersDataSource {

  List<User> getUsers(int count);
}
