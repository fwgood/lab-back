package com.chrome.domain.entity;

import javax.persistence.*;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_content")
    private String courseContent;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "course_state")
    private Integer courseState;

    @Column(name = "course_password")
    private String coursePassword;

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
     * @return course_name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return course_content
     */
    public String getCourseContent() {
        return courseContent;
    }

    /**
     * @param courseContent
     */
    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
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
     * @return course_state
     */
    public Integer getCourseState() {
        return courseState;
    }

    /**
     * @param courseState
     */
    public void setCourseState(Integer courseState) {
        this.courseState = courseState;
    }

    /**
     * @return course_password
     */
    public String getCoursePassword() {
        return coursePassword;
    }

    /**
     * @param coursePassword
     */
    public void setCoursePassword(String coursePassword) {
        this.coursePassword = coursePassword;
    }
}