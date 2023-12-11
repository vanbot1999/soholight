package com.soholighting.sohoTeam8.model;


import java.util.Date;


public class Comments {

    private Integer id;


    private Integer image_id;


    private String content;


    private Date create_time;


    private int user_id;
    private String username;

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
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
// toString Method

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", imageId=" + image_id +
                ", commentText='" + content + '\'' +
                ", createdAt=" + create_time +
                ", userId=" + user_id +
                ", username=" + username +
                '}';
    }
}
