package com.chrome.domain.entity;

import javax.persistence.*;

@Table(name = "user_lab")
public class UserLab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "lab_id")
    private Integer labId;

    private Float score;

    @Column(name = "lab_name")
    private String labName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "commit_url")
    private String commitUrl;

    @Column(name = "commit_content")
    private String commitContent;

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
     * @return lab_id
     */
    public Integer getLabId() {
        return labId;
    }

    /**
     * @param labId
     */
    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    /**
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * @return lab_name
     */
    public String getLabName() {
        return labName;
    }

    /**
     * @param labName
     */
    public void setLabName(String labName) {
        this.labName = labName;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return course_id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * @return commit_url
     */
    public String getCommitUrl() {
        return commitUrl;
    }

    /**
     * @param commitUrl
     */
    public void setCommitUrl(String commitUrl) {
        this.commitUrl = commitUrl;
    }

    /**
     * @return commit_content
     */
    public String getCommitContent() {
        return commitContent;
    }

    /**
     * @param commitContent
     */
    public void setCommitContent(String commitContent) {
        this.commitContent = commitContent;
    }
}