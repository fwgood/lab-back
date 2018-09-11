package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.User;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/10
 * Time:11:26
 */
public interface UserService {
    User login(User user);
    List<User> selectAll();

    User selectByUsername(String username);
}
