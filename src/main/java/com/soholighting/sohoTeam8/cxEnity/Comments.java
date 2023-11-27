package com.soholighting.sohoTeam8.cxEnity;



public class Comments {
    private Integer id;


    private Integer imageId;


    private String commentText;


    private String createdAt;

    private int userId=12138;

    public Comments() {

    }

    public Integer getId() {
        return id;
    }




    public int getUserID() {
        return userId;
    }


    public void setUserID(int UserID) {
        this.userId = UserID;
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


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", imageId=" + imageId +
                ", commentText='" + commentText + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", userId=" + userId +
                '}';
    }

}
