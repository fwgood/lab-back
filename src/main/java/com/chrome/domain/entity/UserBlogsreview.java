package com.chrome.domain.entity;

import javax.persistence.*;

@Table(name = "user_blogsreview")
public class UserBlogsreview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "blogsreview_id")
    private Integer blogsreviewId;

    @Column(name = "is_read")
    private Integer isRead;

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
     * @return is_read
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * @param isRead
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
}