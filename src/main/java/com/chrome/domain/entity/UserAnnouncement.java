package com.chrome.domain.entity;

import javax.persistence.*;

@Table(name = "user_announcement")
public class UserAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "announcement_id")
    private Integer announcementId;

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
     * @return announcement_id
     */
    public Integer getAnnouncementId() {
        return announcementId;
    }

    /**
     * @param announcementId
     */
    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }
}