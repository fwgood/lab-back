package com.chrome.api.service;

import com.chrome.domain.entity.News;
import com.chrome.domain.entity.Page;
import com.github.pagehelper.PageInfo;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/19
 * Time:11:54
 */
public interface NewsService {
    void publishNews(String username, News news);

    PageInfo<News> getNewsList(Page page);
}
