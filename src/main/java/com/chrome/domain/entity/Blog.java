package com.chrome.domain.entity;

import javax.persistence.*;

public class Blog {
    @Id
    @Column(name = "blog_id")
    private Integer blogId;

    @Column(name = "blog_title")
    private String blogTitle;

    @Column(name = "blog_content")
    private String blogContent;

    @Column(name = "blog_time")
    private String blogTime;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_nickname")
    private String userNickname;

    /**
     * @return blog_id
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * @param blogId
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * @return blog_title
     */
    public String getBlogTitle() {
        return blogTitle;
    }

    /**
     * @param blogTitle
     */
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    /**
     * @return blog_content
     */
    public String getBlogContent() {
        return blogContent;
    }

    /**
     * @param blogContent
     */
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    /**
     * @return blog_time
     */
    public String getBlogTime() {
        return blogTime;
    }

    /**
     * @param blogTime
     */
    public void setBlogTime(String blogTime) {
        this.blogTime = blogTime;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_nickname
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * @param userNickname
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}