package com.school.po;

public class Apply {
    private Integer applyId;

    private String userId;

    private String text;

    private Integer check;

    private String freeback;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public String getFreeback() {
        return freeback;
    }

    public void setFreeback(String freeback) {
        this.freeback = freeback == null ? null : freeback.trim();
    }
}