package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.UserService;
import com.chrome.domain.entity.User;
import com.chrome.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/10
 * Time:11:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User user) {
        return userMapper.selectOne(user);

    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
