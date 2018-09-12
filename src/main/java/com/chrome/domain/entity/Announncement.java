package com.chrome.domain.entity;

import javax.persistence.*;

public class Announncement {
    @Id
    @Column(name = "announncement_id")
    private Integer announncementId;

    @Column(name = "announncement_content")
    private String announncementContent;

    @Column(name = "announncement_time")
    private String announncementTime;

    @Column(name = "announncement_type")
    private String announncementType;

    @Column(name = "announncement_course_id")
    private Integer announncementCourseId;

    @Column(name = "announncement_title")
    private String announncementTitle;

    @Column(name = "announncement_user_id")
    private Integer announncementUserId;

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
     * @return announncement_content
     */
    public String getAnnounncementContent() {
        return announncementContent;
    }

    /**
     * @param announncementContent
     */
    public void setAnnounncementContent(String announncementContent) {
        this.announncementContent = announncementContent;
    }

    /**
     * @return announncement_time
     */
    public String getAnnounncementTime() {
        return announncementTime;
    }

    /**
     * @param announncementTime
     */
    public void setAnnounncementTime(String announncementTime) {
        this.announncementTime = announncementTime;
    }

    /**
     * @return announncement_type
     */
    public String getAnnounncementType() {
        return announncementType;
    }

    /**
     * @param announncementType
     */
    public void setAnnounncementType(String announncementType) {
        this.announncementType = announncementType;
    }

    /**
     * @return announncement_course_id
     */
    public Integer getAnnounncementCourseId() {
        return announncementCourseId;
    }

    /**
     * @param announncementCourseId
     */
    public void setAnnounncementCourseId(Integer announncementCourseId) {
        this.announncementCourseId = announncementCourseId;
    }

    /**
     * @return announncement_title
     */
    public String getAnnounncementTitle() {
        return announncementTitle;
    }

    /**
     * @param announncementTitle
     */
    public void setAnnounncementTitle(String announncementTitle) {
        this.announncementTitle = announncementTitle;
    }

    /**
     * @return announncement_user_id
     */
    public Integer getAnnounncementUserId() {
        return announncementUserId;
    }

    /**
     * @param announncementUserId
     */
    public void setAnnounncementUserId(Integer announncementUserId) {
        this.announncementUserId = announncementUserId;
    }
}