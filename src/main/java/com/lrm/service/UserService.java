package com.lrm.service;

import com.lrm.po.User;
import com.lrm.vo.UserQuery;
import org.springframework.data.domain.Pageable;

/**
 * Created by limi on 2017/10/15.
 */
public interface UserService {

    User checkUser(String username, String password);

    Object listUser(Pageable pageable, UserQuery user);

    User saveUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUser(Long id);

    Object listUser(Pageable pageable);
}
