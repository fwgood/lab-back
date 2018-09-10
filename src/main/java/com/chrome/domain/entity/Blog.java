package com.chrome.domain.entity;

import javax.persistence.*;

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer blog;

    @Column(name = "blog_title")
    private String blogTitle;

    @Column(name = "blog_content")
    private String blogContent;

    @Column(name = "blog_time")
    private String blogTime;

    /**
     * @return blog
     */
    public Integer getBlog() {
        return blog;
    }

    /**
     * @param blog
     */
    public void setBlog(Integer blog) {
        this.blog = blog;
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
}