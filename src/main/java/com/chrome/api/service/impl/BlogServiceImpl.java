package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.BlogService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Blog;
import com.chrome.domain.entity.Blogsreview;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.User;
import com.chrome.infra.mapper.BlogMapper;
import com.chrome.infra.mapper.BlogsreviewMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Autowired
    private BlogsreviewMapper blogsreviewMapper;
    @Override
    public PageInfo<Blog> getBlogList(Integer courseId, Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize());
        List<Blog> blogList = blogMapper.getBlogList(courseId);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public List<Blog> getUserBlogList(String username) {
        User user = userService.selectByUsername(username);
        Blog blog=new Blog();
        blog.setUserId(user.getUserId());
        blog.setUserNickname(user.getUserNickname());
      return   blogMapper.select(blog);


    }

    @Override
    public void publishBlog(String username, Blog blog) {
        User user = userService.selectByUsername(username);
        blog.setUserNickname(user.getUserNickname());
        blog.setUserId(user.getUserId());
        blogMapper.insertSelective(blog);
    }

    @Override
    public void publishComment(String username, Blogsreview blogsreview) {
        User user = userService.selectByUsername(username);
        blogsreview.setBlogsreviewUserid(user.getUserId());
        blogsreviewMapper.insertSelective(blogsreview);
    }

    @Override
    public List<Blogsreview> getComments(Integer parentId) {
        Blogsreview blogsreview =new Blogsreview();
        blogsreview.setBlogsreviewParentid(parentId);
       return blogsreviewMapper.select(blogsreview);
    }
}
