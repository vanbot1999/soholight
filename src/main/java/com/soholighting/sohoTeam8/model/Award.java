package com.soholighting.sohoTeam8.model;


public class Award {
    private String id;

    private String name;
    private String date;
    private String description;

    // Constructor
    public Award(String id, String name, String date, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    // Getters
    public String getId(){
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
}