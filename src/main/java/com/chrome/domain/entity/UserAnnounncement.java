package com.chrome.domain.entity;

import javax.persistence.*;

@Table(name = "user_announncement")
public class UserAnnounncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "announncement_id")
    private Integer announncementId;

    @Column(name = "is_read")
    private String isRead;

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
     * @return announncement_id
     */
    public Integer getAnnounncementId() {
        return announncementId;
    }

    /**
     * @param announncementId
     */
    public void setAnnounncementId(Integer announncementId) {
        this.announncementId = announncementId;
    }

    /**
     * @return is_read
     */
    public String getIsRead() {
        return isRead;
    }

    /**
     * @param isRead
     */
    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }
}