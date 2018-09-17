package com.chrome.api.service;

import java.util.List;

import com.chrome.domain.entity.Blog;
import com.chrome.domain.entity.Blogsreview;
import com.chrome.domain.entity.Page;
import com.github.pagehelper.PageInfo;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:15:43
 */
public interface BlogService {
    PageInfo<Blog> getBlogList(Integer courseId, Page page);

    PageInfo<Blog> getUserBlogList(String username, Page page);

    void publishBlog(String username, Blog blog);

    void publishComment(String username, Blogsreview blogsreview);

    List<Blogsreview> getComments(Integer parentId);

    PageInfo<Blog> searchBlog(String param, Page page);
}
