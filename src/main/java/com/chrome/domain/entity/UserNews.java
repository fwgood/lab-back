package com.chrome.domain.entity;

import javax.persistence.*;

@Table(name = "user_news")
public class UserNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "new_id")
    private Integer newId;

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
     * @return new_id
     */
    public Integer getNewId() {
        return newId;
    }

    /**
     * @param newId
     */
    public void setNewId(Integer newId) {
        this.newId = newId;
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