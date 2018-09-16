package com.chrome.api.dto;

/**
 * Created with IDEA
 * author:Chengcong
 * Date:2018/9/17
 * Time:3:05
 */
public class CommitLabDto {
    private String commitUrl;
    private String commitContent;
    private Integer labId;

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
}
