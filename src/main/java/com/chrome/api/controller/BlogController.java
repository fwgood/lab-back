package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import com.chrome.api.service.BlogService;
import com.chrome.api.service.BlogsreviewService;
import com.chrome.domain.entity.Blog;
import com.chrome.infra.annotation.AuthToken;
import com.chrome.infra.interceptor.AuthorizationInterceptor;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @Autowired
    private BlogsreviewService blogsreviewService;




    @ApiOperation("查询所有博客按时间")
    @RequestMapping(value = "/blogList", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<List<Blog>> getBlogList() {

        List<Blog> list= blogService.getBlogList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @ApiOperation("查询所有博客按当前用户")
    @RequestMapping(value = "/userBlogList", method = RequestMethod.GET)
    @AuthToken
    public ResponseEntity<List<Blog>> getUserBlogList(HttpServletRequest request) {
        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);

        List<Blog> list= blogService.getUserBlogList(username);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
