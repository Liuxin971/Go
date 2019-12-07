package com.sx.ybj.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
@Document(indexName = "feed",type = "feedback")
public class Feedback {
    @Id
    private Integer feedbackId;

    private Date feedbackCreate;

    private String feedbackTheme;

    private String feedbackContent;

    private Integer userId;

    private Integer feedbackAdmin;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Date getFeedbackCreate() {
        return feedbackCreate;
    }

    public void setFeedbackCreate(Date feedbackCreate) {
        this.feedbackCreate = feedbackCreate;
    }

    public String getFeedbackTheme() {
        return feedbackTheme;
    }

    public void setFeedbackTheme(String feedbackTheme) {
        this.feedbackTheme = feedbackTheme == null ? null : feedbackTheme.trim();
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFeedbackAdmin() {
        return feedbackAdmin;
    }

    public void setFeedbackAdmin(Integer feedbackAdmin) {
        this.feedbackAdmin = feedbackAdmin;
    }
}