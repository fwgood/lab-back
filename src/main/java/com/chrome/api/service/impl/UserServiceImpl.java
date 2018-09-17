package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.UserService;
import com.chrome.domain.entity.*;
import com.chrome.infra.mapper.*;
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
    @Autowired
    private SelectcourseMapper selectcourseMapper;
    @Autowired
    private StartcourseMapper startcourseMapper;
    @Autowired
    private UserLabMapper userLabMapper;
    @Autowired
    private AnnounncementMapper announncementMapper;

//登陆
    @Override
    public User login(User user) {
        return userMapper.selectOne(user);

    }
//根据用户名获得当前用户
    @Override
    public User selectByUsername(String username) {
        User user=new User();
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
    public void updateUser(String username, String userPassword, String avater, String phone) {
        User user=new User();
        user.setUserName(username);
        User user1 = userMapper.selectOne(user);
        user1.setUserPassword(userPassword);
        user1.setUserAvatar(avater);
        user1.setUserPhone(phone);
        userMapper.updateByPrimaryKeySelective(user1);

    }

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);

    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
        Selectcourse selectcourse =new Selectcourse();
        selectcourse.setUserId(userId);
        selectcourseMapper.delete(selectcourse);
        Startcourse startcourse =new Startcourse();
        startcourse.setUserId(userId);
        startcourseMapper.delete(startcourse);
        UserLab userLab =new UserLab();
        userLab.setUserId(userId);
        userLabMapper.delete(userLab);
        Announncement announncement=new Announncement();
        announncement.setAnnounncementUserId(userId);
        announncementMapper.delete(announncement);
        //博客添加后 需级联删除


    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public void updateState(Integer userId, String role) {
        User user =new User();
        user.setUserId(userId);
        user.setUserRole(role);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void regist(User user) {
        userMapper.insertSelective(user);
    }
}
