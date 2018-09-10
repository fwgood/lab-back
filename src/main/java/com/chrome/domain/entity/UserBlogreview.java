package com.chrome.domain.entity;

import javax.persistence.*;

@Table(name = "user_blogreview")
public class UserBlogreview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "blogsreview_id")
    private Integer blogsreviewId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return blogsreview_id
     */
    public Integer getBlogsreviewId() {
        return blogsreviewId;
    }

    /**
     * @param blogsreviewId
     */
    public void setBlogsreviewId(Integer blogsreviewId) {
        this.blogsreviewId = blogsreviewId;
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
}