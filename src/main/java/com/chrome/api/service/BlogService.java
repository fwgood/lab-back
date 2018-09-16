package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Blog;
import com.chrome.domain.entity.Blogsreview;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:15:43
 */
public interface BlogService {
    List<Blog> getBlogList(Integer courseId);

    List<Blog> getUserBlogList(String username);

    void publishBlog(String username, Blog blog);

    void publishComment(String username, Blogsreview blogsreview);

    List<Blogsreview> getComments(Integer parentId);
}
