package com.chrome.api.dto;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/19
 * Time:13:52
 */
public class AnnoIsReadDto {


    private Integer announncementId;


    private String announncementContent;


    private String announncementTime;


    private String announncementType;


    private Integer announncementCourseId;


    private String announncementTitle;

    private Integer announncementUserId;

    private String isRead;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnnounncementId() {
        return announncementId;
    }

    public void setAnnounncementId(Integer announncementId) {
        this.announncementId = announncementId;
    }

    public String getAnnounncementContent() {
        return announncementContent;
    }

    public void setAnnounncementContent(String announncementContent) {
        this.announncementContent = announncementContent;
    }

    public String getAnnounncementTime() {
        return announncementTime;
    }

    public void setAnnounncementTime(String announncementTime) {
        this.announncementTime = announncementTime;
    }

    public String getAnnounncementType() {
        return announncementType;
    }

    public void setAnnounncementType(String announncementType) {
        this.announncementType = announncementType;
    }

    public Integer getAnnounncementCourseId() {
        return announncementCourseId;
    }

    public void setAnnounncementCourseId(Integer announncementCourseId) {
        this.announncementCourseId = announncementCourseId;
    }

    public String getAnnounncementTitle() {
        return announncementTitle;
    }

    public void setAnnounncementTitle(String announncementTitle) {
        this.announncementTitle = announncementTitle;
    }

    public Integer getAnnounncementUserId() {
        return announncementUserId;
    }

    public void setAnnounncementUserId(Integer announncementUserId) {
        this.announncementUserId = announncementUserId;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }
}
