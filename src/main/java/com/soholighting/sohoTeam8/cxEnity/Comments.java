package com.soholighting.sohoTeam8.cxEnity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comments {
    private Integer id;


    private Integer imageId;


    private String commentText;


    private LocalDateTime createdAt;

    private int userid=12138;

    public Comments() {

    }

    public Integer getId() {
        return id;
    }



    // Since UserID is default, you may not need a setter, but it's here if you want to change it later
    public int getUserID() {
        return userid;
    }

    // Since UserID is default, you may not need a setter, but it's here if you want to change it later
    public void setUserID(int UserID) {
        this.userid = UserID;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
