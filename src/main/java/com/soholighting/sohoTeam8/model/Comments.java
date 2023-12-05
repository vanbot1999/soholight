package com.soholighting.sohoTeam8.model;


import java.util.Date;


public class Comments {

    private Integer id;


    private Integer image_id;


    private String content;


    private Date create_time;


    private int userId=12138;

    public Comments() {
        // Default constructor
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageId() {
        return image_id;
    }

    public void setImageId(Integer image_id) {
        this.image_id = image_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // toString Method

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", imageId=" + image_id +
                ", commentText='" + content + '\'' +
                ", createdAt=" + create_time +
                ", userId=" + userId +
                '}';
    }
}
