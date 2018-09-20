package com.chrome.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.chrome.api.service.BlogService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.Blog;
import com.chrome.domain.entity.Blogsreview;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.User;
import com.chrome.infra.globalexception.CommonException;
import com.chrome.infra.mapper.BlogMapper;
import com.chrome.infra.mapper.BlogsreviewMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        PageHelper.startPage(page.getPage(), page.getPageSize(), "blog_time " + page.getSort());
        List<Blog> blogList = blogMapper.getBlogList(courseId);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public PageInfo<Blog> getUserBlogList(String username, Page page) {
        User user = userService.selectByUsername(username);
        Blog blog = new Blog();
        blog.setUserId(user.getUserId());
        blog.setUserNickname(user.getUserNickname());
        PageHelper.startPage(page.getPage(), page.getPageSize(), "blog_time " + page.getSort());
        PageInfo<Blog> pageInfo = new PageInfo<>(blogMapper.select(blog));
        return pageInfo;
    }

    @Override
    @Transactional
    public void publishBlog(String username, Blog blog) {
        User user = userService.selectByUsername(username);
        blog.setUserNickname(user.getUserNickname());
        blog.setUserId(user.getUserId());
        int i = blogMapper.insertSelective(blog);
        if (i != 1) {
            throw new CommonException("error.Blog.create");
        }
    }

    @Override
    @Transactional
    public void publishComment(String username, Blogsreview blogsreview) {
        User user = userService.selectByUsername(username);
        blogsreview.setBlogsreviewUserid(user.getUserId());
        blogsreview.setUserNickname(user.getUserNickname());
        blogsreview.setUserAvatar(user.getUserAvatar());
        int i = blogsreviewMapper.insertSelective(blogsreview);
        if (i != 1) {
            throw new CommonException("error.Comment.create");
        }
    }

    @Override
    public List<Blogsreview> getComments(Integer parentId) {
        Blogsreview blogsreview = new Blogsreview();
        blogsreview.setBlogsreviewParentid(parentId);
        return blogsreviewMapper.select(blogsreview);
    }

    @Override
    public PageInfo<Blog> searchBlog(String param, Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize(), "blog_id " + page.getSort());
        List<Blog> blogList = blogMapper.searchBlog(param);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public Integer addBlogCount(Integer blogId,Integer op) {
        Blog blog1 = blogMapper.selectByPrimaryKey(blogId);
        Integer blogCount = blog1.getBlogCount();
        blogCount = blogCount+op;
        blog1.setBlogCount(blogCount);
        int i = blogMapper.updateByPrimaryKeySelective(blog1);
        if(i!=1){
            throw new CommonException("error.addcount.blog");
        }
        return blogCount;
    }

    @Override
    public List<Blogsreview> getAllComments(String username) {
        User user = userService.selectByUsername(username);
        Blog blog=new Blog();
        blog.setUserId(user.getUserId());
        List<Blog> select = blogMapper.select(blog);
        List<Blogsreview> result=new ArrayList<>();
        for(int i=0;i<select.size();i++){
            Blogsreview blogsreview =new Blogsreview();
            blogsreview.setBlogsreviewParentid(select.get(i).getBlogId());
            List<Blogsreview> list = blogsreviewMapper.select(blogsreview);
            result.addAll(list);
        }
        return result;
    }

    @Override
    public void updateIsRead(Integer blogsReviewId) {
        Blogsreview blogsreview = blogsreviewMapper.selectByPrimaryKey(blogsReviewId);
        blogsreview.setIsRead("1");
        int i = blogsreviewMapper.updateByPrimaryKeySelective(blogsreview);
        if(i!=1){
            throw new CommonException("error.update.blossreview");
        }

    }
}
