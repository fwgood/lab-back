package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.BlogService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Blog;
import com.chrome.domain.entity.User;
import com.chrome.infra.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:15:42
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserService userService;
    @Override
    public List<Blog> getBlogList() {
        return blogMapper.getBlogList();
    }

    @Override
    public List<Blog> getUserBlogList(String username) {
        User user = userService.selectByUsername(username);
        Blog blog=new Blog();
        blog.setUserId(user.getUserId());
        blog.setUserNickname(user.getUserNickname());
      return   blogMapper.select(blog);


    }
}
