package com.chrome.domain.entity;

import javax.persistence.*;

public class Lab {
    @Id
    @Column(name = "lab_id")
    private Integer labId;

    @Column(name = "lab_name")
    private String labName;

    @Column(name = "lab_content")
    private String labContent;

    @Column(name = "lab_url")
    private String labUrl;

    @Column(name = "lab_starttime")
    private String labStarttime;

    @Column(name = "lab_deadline")
    private String labDeadline;

    @Column(name = "course_id")
    private Integer courseId;

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
     * @return lab_content
     */
    public String getLabContent() {
        return labContent;
    }

    /**
     * @param labContent
     */
    public void setLabContent(String labContent) {
        this.labContent = labContent;
    }

    /**
     * @return lab_url
     */
    public String getLabUrl() {
        return labUrl;
    }

    /**
     * @param labUrl
     */
    public void setLabUrl(String labUrl) {
        this.labUrl = labUrl;
    }

    /**
     * @return lab_starttime
     */
    public String getLabStarttime() {
        return labStarttime;
    }

    /**
     * @param labStarttime
     */
    public void setLabStarttime(String labStarttime) {
        this.labStarttime = labStarttime;
    }

    /**
     * @return lab_deadline
     */
    public String getLabDeadline() {
        return labDeadline;
    }

    /**
     * @param labDeadline
     */
    public void setLabDeadline(String labDeadline) {
        this.labDeadline = labDeadline;
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
}