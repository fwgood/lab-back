package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.dto.UpdateUserDto;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.User;
import com.chrome.infra.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //登陆
    @Override
    public User login(User user) {
        return userMapper.selectOne(user);

    }

    //根据用户名获得当前用户
    @Override
    public User selectByUsername(String username) {
        User user = new User();
        user.setUserName(username);
        return userMapper.selectOne(user);
    }

    //列出所有用户
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    //获取用户的权限
    @Override
    public String getRole(String username) {
        return userMapper.getRole(username);
    }

    @Override
    public void updateUser(String username, UpdateUserDto updateUserDto) {
        User user = new User();
        user.setUserName(username);
        User user1 = userMapper.selectOne(user);
        user1.setUserPassword(updateUserDto.getUserPassword());
        user1.setUserAvatar(updateUserDto.getUserAvatar());
        user1.setUserPhone(updateUserDto.getUserPhone());
        user1.setUserNickname(updateUserDto.getUserNickname());
        user1.setUserCollege(updateUserDto.getUserCollege());
        user1.setUserGrade(updateUserDto.getUserGrade());
        user1.setUserSex(updateUserDto.getUserSex());
        user1.setUserMajor(updateUserDto.getUserMajor());
        userMapper.updateByPrimaryKeySelective(user1);

    }

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);

    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public PageInfo<User> getAllUser(Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize(), "user_id " + page.getSort());
        return new PageInfo<>(userMapper.selectAll());

    }

    @Override
    @Transactional
    public void updateState(Integer userId, String role) {
        User user = new User();
        user.setUserId(userId);
        user.setUserRole(role);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional
    public void regist(User user) {
        userMapper.insertSelective(user);
    }
}
