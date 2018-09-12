package com.chrome.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Blogsreview {
    @Id
    @Column(name = "blogsreview_id")
    private Integer blogsreviewId;

    @Column(name = "blogsreview_userid")
    private Integer blogsreviewUserid;

    @Column(name = "blogsreview_content")
    private String blogsreviewContent;

    @Column(name = "blogsreview_time")
    private Date blogsreviewTime;

    @Column(name = "blogsreview_parentid")
    private Integer blogsreviewParentid;

    /**
     * @return blogsreview_id
     */
    public Integer getBlogsreviewId() {
        return blogsreviewId;
    }

    /**
     * @param blogsreviewId
     */
    public void setBlogsreviewId(Integer blogsreviewId) {
        this.blogsreviewId = blogsreviewId;
    }

    /**
     * @return blogsreview_userid
     */
    public Integer getBlogsreviewUserid() {
        return blogsreviewUserid;
    }

    /**
     * @param blogsreviewUserid
     */
    public void setBlogsreviewUserid(Integer blogsreviewUserid) {
        this.blogsreviewUserid = blogsreviewUserid;
    }

    /**
     * @return blogsreview_content
     */
    public String getBlogsreviewContent() {
        return blogsreviewContent;
    }

    /**
     * @param blogsreviewContent
     */
    public void setBlogsreviewContent(String blogsreviewContent) {
        this.blogsreviewContent = blogsreviewContent;
    }

    /**
     * @return blogsreview_time
     */
    public Date getBlogsreviewTime() {
        return blogsreviewTime;
    }

    /**
     * @param blogsreviewTime
     */
    public void setBlogsreviewTime(Date blogsreviewTime) {
        this.blogsreviewTime = blogsreviewTime;
    }

    /**
     * @return blogsreview_parentid
     */
    public Integer getBlogsreviewParentid() {
        return blogsreviewParentid;
    }

    /**
     * @param blogsreviewParentid
     */
    public void setBlogsreviewParentid(Integer blogsreviewParentid) {
        this.blogsreviewParentid = blogsreviewParentid;
    }
}