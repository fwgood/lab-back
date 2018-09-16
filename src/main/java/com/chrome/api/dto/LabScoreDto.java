package com.chrome.api.dto;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/12
 * Time:15:11
 */
public class LabScoreDto {

    private Integer labId;

    private String  labName;

    private String  labContent;

    private String  labUrl;

    private String  labStarttime;

    private String  labDeadline;

    private Float   score;

    private String commitUrl;

    private String commitContent;

    public String getCommitUrl() {
        return commitUrl;
    }

    public void setCommitUrl(String commitUrl) {
        this.commitUrl = commitUrl;
    }

    public String getCommitContent() {
        return commitContent;
    }

    public void setCommitContent(String commitContent) {
        this.commitContent = commitContent;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabContent() {
        return labContent;
    }

    public void setLabContent(String labContent) {
        this.labContent = labContent;
    }

    public String getLabUrl() {
        return labUrl;
    }

    public void setLabUrl(String labUrl) {
        this.labUrl = labUrl;
    }

    public String getLabStarttime() {
        return labStarttime;
    }

    public void setLabStarttime(String labStarttime) {
        this.labStarttime = labStarttime;
    }

    public String getLabDeadline() {
        return labDeadline;
    }

    public void setLabDeadline(String labDeadline) {
        this.labDeadline = labDeadline;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
