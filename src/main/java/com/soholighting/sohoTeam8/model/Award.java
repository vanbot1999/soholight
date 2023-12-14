package com.soholighting.sohoTeam8.model;
// Represents a RIBA award given out in SOHO Xmas kids lights.
public class Award {
    private String id;
    // Name of the winner of the award.
    private String winnerName;
    // Background information about the winner (Year X).
    private String winnerBackground;
    //Quote
    private String winnerSpeech;
    //Kids' Motif
    private String winnerImage;
    public Award() {
    }
    // Constructor for creating an Award instance with all fields.
    public Award(String id, String winnerName, String winnerBackground, String winnerSpeech, String winnerImage) {
        this.id = id;
        this.winnerName = winnerName;
        this.winnerBackground = winnerBackground;
        this.winnerSpeech = winnerSpeech;
        this.winnerImage = winnerImage;
    }
    // Getters and setters for accessing and updating the properties.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getWinnerBackground() {
        return winnerBackground;
    }

    public void setWinnerBackground(String winnerBackground) {
        this.winnerBackground = winnerBackground;
    }

    public String getWinnerSpeech() {
        return winnerSpeech;
    }

    public void setWinnerSpeech(String winnerSpeech) {
        this.winnerSpeech = winnerSpeech;
    }

    public String getWinnerImage() {
        return winnerImage;
    }

    public void setWinnerImage(String winnerImage) {
        this.winnerImage = winnerImage;
    }
}
