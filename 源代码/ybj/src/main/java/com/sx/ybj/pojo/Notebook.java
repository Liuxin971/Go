package com.sx.ybj.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
@Document(indexName = "notebook",type = "note")
public class Notebook {
    @Id
    private Integer notebookId;

    private String notebookTitle;

    private String notebookContent;

    private String notebookAbstract;

    private Date notebookRegdate;

    private Date notebookModfiy;

    private Integer notebookAccess;

    private Integer notebookState;

    private Integer notebookSharing;

    private Integer notebookActivityNote;

    private Integer categorizeId;

    private Integer userId;

    private String notebookUrl;

    private Integer notebookCollect;


    @Override
    public String toString() {
        return "Notebook{" +
                "notebookId=" + notebookId +
                ", notebookTitle='" + notebookTitle + '\'' +
                ", notebookContent='" + notebookContent + '\'' +
                ", notebookAbstract='" + notebookAbstract + '\'' +
                ", notebookRegdate=" + notebookRegdate +
                ", notebookModfiy=" + notebookModfiy +
                ", notebookAccess=" + notebookAccess +
                ", notebookState=" + notebookState +
                ", notebookSharing=" + notebookSharing +
                ", notebookActivityNote=" + notebookActivityNote +
                ", categorizeId=" + categorizeId +
                ", userId=" + userId +
                ", notebookUrl='" + notebookUrl + '\'' +
                ", notebookCollect=" + notebookCollect +
                '}';
    }

    public Integer getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(Integer notebookId) {
        this.notebookId = notebookId;
    }

    public String getNotebookTitle() {
        return notebookTitle;
    }

    public void setNotebookTitle(String notebookTitle) {
        this.notebookTitle = notebookTitle == null ? null : notebookTitle.trim();
    }

    public String getNotebookContent() {
        return notebookContent;
    }

    public void setNotebookContent(String notebookContent) {
        this.notebookContent = notebookContent == null ? null : notebookContent.trim();
    }

    public String getNotebookAbstract() {
        return notebookAbstract;
    }

    public void setNotebookAbstract(String notebookAbstract) {
        this.notebookAbstract = notebookAbstract == null ? null : notebookAbstract.trim();
    }

    public Date getNotebookRegdate() {
        return notebookRegdate;
    }

    public void setNotebookRegdate(Date notebookRegdate) {
        this.notebookRegdate = notebookRegdate;
    }

    public Date getNotebookModfiy() {
        return notebookModfiy;
    }

    public void setNotebookModfiy(Date notebookModfiy) {
        this.notebookModfiy = notebookModfiy;
    }

    public Integer getNotebookAccess() {
        return notebookAccess;
    }

    public void setNotebookAccess(Integer notebookAccess) {
        this.notebookAccess = notebookAccess;
    }

    public Integer getNotebookState() {
        return notebookState;
    }

    public void setNotebookState(Integer notebookState) {
        this.notebookState = notebookState;
    }

    public Integer getNotebookSharing() {
        return notebookSharing;
    }

    public void setNotebookSharing(Integer notebookSharing) {
        this.notebookSharing = notebookSharing;
    }

    public Integer getNotebookActivityNote() {
        return notebookActivityNote;
    }

    public void setNotebookActivityNote(Integer notebookActivityNote) {
        this.notebookActivityNote = notebookActivityNote;
    }

    public Integer getCategorizeId() {
        return categorizeId;
    }

    public void setCategorizeId(Integer categorizeId) {
        this.categorizeId = categorizeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNotebookUrl() {
        return notebookUrl;
    }

    public void setNotebookUrl(String notebookUrl) {
        this.notebookUrl = notebookUrl == null ? null : notebookUrl.trim();
    }

    public Integer getNotebookCollect() {
        return notebookCollect;
    }

    public void setNotebookCollect(Integer notebookCollect) {
        this.notebookCollect = notebookCollect;
    }
}