package com.chrome.domain.entity;

import javax.persistence.*;

public class News {
    @Id
    @Column(name = "news_id")
    private Integer newsId;

    @Column(name = "news_sendid")
    private Integer newsSendid;

    @Column(name = "news_sendname")
    private String newsSendname;

    @Column(name = "news_acceptid")
    private Integer newsAcceptid;

    @Column(name = "news_acceptname")
    private String newsAcceptname;

    @Column(name = "news_content")
    private String newsContent;

    @Column(name = "news_time")
    private String newsTime;

    @Column(name = "news_state")
    private String newsState;

    /**
     * @return news_id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * @param newsId
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * @return news_sendid
     */
    public Integer getNewsSendid() {
        return newsSendid;
    }

    /**
     * @param newsSendid
     */
    public void setNewsSendid(Integer newsSendid) {
        this.newsSendid = newsSendid;
    }

    /**
     * @return news_sendname
     */
    public String getNewsSendname() {
        return newsSendname;
    }

    /**
     * @param newsSendname
     */
    public void setNewsSendname(String newsSendname) {
        this.newsSendname = newsSendname;
    }

    /**
     * @return news_acceptid
     */
    public Integer getNewsAcceptid() {
        return newsAcceptid;
    }

    /**
     * @param newsAcceptid
     */
    public void setNewsAcceptid(Integer newsAcceptid) {
        this.newsAcceptid = newsAcceptid;
    }

    /**
     * @return news_acceptname
     */
    public String getNewsAcceptname() {
        return newsAcceptname;
    }

    /**
     * @param newsAcceptname
     */
    public void setNewsAcceptname(String newsAcceptname) {
        this.newsAcceptname = newsAcceptname;
    }

    /**
     * @return news_content
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * @param newsContent
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    /**
     * @return news_time
     */
    public String getNewsTime() {
        return newsTime;
    }

    /**
     * @param newsTime
     */
    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    /**
     * @return news_state
     */
    public String getNewsState() {
        return newsState;
    }

    /**
     * @param newsState
     */
    public void setNewsState(String newsState) {
        this.newsState = newsState;
    }
}