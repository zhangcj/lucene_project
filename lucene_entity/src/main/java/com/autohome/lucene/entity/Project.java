package com.autohome.lucene.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/13.
 */
public class Project {
    private int pId;
    private String pTopic;
    private String pDesc;
    private String pUrl;
    private Date CreatedAt;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpTopic() {
        return pTopic;
    }

    public void setpTopic(String pTopic) {
        this.pTopic = pTopic;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
