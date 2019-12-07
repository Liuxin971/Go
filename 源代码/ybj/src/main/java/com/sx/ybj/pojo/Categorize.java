package com.sx.ybj.pojo;

public class Categorize {
    private Integer categorizeId;

    private String categorizeName;

    private Integer userId;

    private Integer categorizeState;

    public Integer getCategorizeId() {
        return categorizeId;
    }

    public void setCategorizeId(Integer categorizeId) {
        this.categorizeId = categorizeId;
    }

    public String getCategorizeName() {
        return categorizeName;
    }

    public void setCategorizeName(String categorizeName) {
        this.categorizeName = categorizeName == null ? null : categorizeName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategorizeState() {
        return categorizeState;
    }

    public void setCategorizeState(Integer categorizeState) {
        this.categorizeState = categorizeState;
    }
}