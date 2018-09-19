package com.chrome.api.controller;

import javax.servlet.http.HttpServletRequest;

import com.chrome.api.service.NewsService;
import com.chrome.domain.entity.News;
import com.chrome.domain.entity.Page;
import com.chrome.infra.annotation.AuthToken;
import com.chrome.infra.interceptor.AuthorizationInterceptor;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/19
 * Time:11:53
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/blog")
public class NewsController {
    @Autowired
    private NewsService newsService;



    @ApiOperation("发布新闻")
    @RequestMapping(value = "/publishNews", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<Object> publishNews(HttpServletRequest request, @RequestBody News news) {
        String username = (String) request.getAttribute(AuthorizationInterceptor.REQUEST_CURRENT_KEY);

      newsService.publishNews(username, news);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @ApiOperation("展示所有新闻")
    @RequestMapping(value = "/newsList", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<PageInfo<News>> getNewsList(@RequestBody(required = false) Page page) {


        PageInfo<News> list =newsService.getNewsList(page);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
