package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.chrome.api.service.BlogService;
import com.chrome.domain.entity.Blog;
import com.chrome.domain.entity.Blogsreview;
import com.chrome.domain.entity.Page;
import com.chrome.infra.annotation.AuthToken;
import com.chrome.infra.interceptor.AuthorizationInterceptor;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/14
 * Time:15:42
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;


    @ApiOperation("查询所有博客按courseId查询")
    @RequestMapping(value = "/blogList", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<PageInfo<Blog>> getBlogList(@RequestParam Integer courseId, @RequestBody(required = false) Page page) {

        PageInfo<Blog> blogList = blogService.getBlogList(courseId, page);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @ApiOperation("模糊查询搜索博客")
    @RequestMapping(value = "/searchBlog", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<PageInfo<Blog>> searchBlog(@RequestParam String param, @RequestBody(required = false) Page page) {

        PageInfo<Blog> blogList = blogService.searchBlog(param, page);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @ApiOperation("查询所有博客按当前用户")
    @RequestMapping(value = "/userBlogList", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<PageInfo<Blog>> getUserBlogList(HttpServletRequest request, @RequestBody(required = false) Page page) {
        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);

        PageInfo<Blog> blogList = blogService.getUserBlogList(username, page);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @ApiOperation("当前用户发布博客")
    @RequestMapping(value = "/publishBlog", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> publishBlog(HttpServletRequest request, @RequestBody Blog blog) {
        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);

        blogService.publishBlog(username, blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("当前用户发表评论")
    @RequestMapping(value = "/publishComment", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> publishComment(HttpServletRequest request, @RequestBody Blogsreview blogsreview) {
        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);

        blogService.publishComment(username, blogsreview);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("获取当前内容下的所有评论")
    @RequestMapping(value = "/getComments", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<List<Blogsreview>> getComments(@RequestParam Integer parentId) {
        List<Blogsreview> list = blogService.getComments(parentId);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation("点赞数++")
    @RequestMapping(value = "/addBlogCount", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Integer> addBlogCount(@RequestParam Integer blogId) {
        Integer i = blogService.addBlogCount(blogId);

        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @ApiOperation("获取当前用户的所有评论")
    @RequestMapping(value = "/getAllComments", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<List<Blogsreview>> getAllComments(HttpServletRequest request) {
        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);
        List<Blogsreview> list = blogService.getAllComments(username);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation("设置评论已查看")
    @RequestMapping(value = "/updateIsRead", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> updateIsRead(@RequestParam Integer blogsReviewId) {

        blogService.updateIsRead(blogsReviewId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
