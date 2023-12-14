package com.soholighting.sohoTeam8.model;

// Model class representing a Feedback entity
public class Feedback {
    private String username;
    private String email;
    private String message;
    // Default constructor
    public Feedback() {
    }
    // Constructor with parameters
    public Feedback(String username, String email, String message) {
        this.username = username;
        this.email = email;
        this.message = message;
    }
    // Getters and setters for each field
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "Feedback{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

