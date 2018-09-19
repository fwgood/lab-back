package com.chrome.api.service.impl;

import java.util.List;

import com.chrome.api.service.NewsService;
import com.chrome.api.service.UserService;
import com.chrome.domain.entity.News;
import com.chrome.domain.entity.Page;
import com.chrome.domain.entity.User;
import com.chrome.infra.mapper.NewsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/19
 * Time:11:54
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private UserService userService;
    @Autowired
    private NewsMapper newsMapper;


    @Override
    public void publishNews(String username, News news) {
        User user = userService.selectByUsername(username);
        news.setNewsSendid(user.getUserId());
        news.setNewsSendname(user.getUserNickname());
        newsMapper.insertSelective(news);
    }

    @Override
    public PageInfo<News> getNewsList(Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize(), "news_time " + page.getSort());
        List<News> list = newsMapper.selectAll();
        PageInfo<News> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
