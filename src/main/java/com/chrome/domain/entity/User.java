package com.chrome.domain.entity;

import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "user_avatar")
    private String userAvatar;

    @Column(name = "user_grade")
    private String userGrade;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_college")
    private String userCollege;

    @Column(name = "user_major")
    private String userMajor;

    @Column(name = "user_lastsignin")
    private String userLastsignin;

    @Column(name = "user_sex")
    private String userSex;

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
     * @return user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return user_nickname
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * @param userNickname
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * @return user_role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return user_avatar
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * @param userAvatar
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * @return user_grade
     */
    public String getUserGrade() {
        return userGrade;
    }

    /**
     * @param userGrade
     */
    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return user_college
     */
    public String getUserCollege() {
        return userCollege;
    }

    /**
     * @param userCollege
     */
    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege;
    }

    /**
     * @return user_major
     */
    public String getUserMajor() {
        return userMajor;
    }

    /**
     * @param userMajor
     */
    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }

    /**
     * @return user_lastsignin
     */
    public String getUserLastsignin() {
        return userLastsignin;
    }

    /**
     * @param userLastsignin
     */
    public void setUserLastsignin(String userLastsignin) {
        this.userLastsignin = userLastsignin;
    }

    /**
     * @return user_sex
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * @param userSex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}