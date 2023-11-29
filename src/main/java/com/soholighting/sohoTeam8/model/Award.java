package com.soholighting.sohoTeam8.model;


public class Award {
    private String id;
    private String name;
    private String date;
    private String description;
    private String imageUrl;

    // Constructor
    public Award(String id, String name, String date, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}