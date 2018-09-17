package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.User;
import com.github.pagehelper.PageInfo;

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

    String getRole(String username);


    void updateUser(String username, String userPassword, String avater, String phone);

    void addUser(User user);

    void deleteUser(Integer userId);

    PageInfo<User> getAllUser(Page page);

    void updateState(Integer userId, String role);

    void regist(User user);
}
