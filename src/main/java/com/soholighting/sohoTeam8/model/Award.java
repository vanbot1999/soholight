package com.soholighting.sohoTeam8.model;

public class Award {
    private String id;
    private String winnerName;
    private String winnerBackground;
    private String winnerSpeech;
    private String winnerImage;
    public Award() {
    }

    public Award(String id, String winnerName, String winnerBackground, String winnerSpeech, String winnerImage) {
        this.id = id;
        this.winnerName = winnerName;
        this.winnerBackground = winnerBackground;
        this.winnerSpeech = winnerSpeech;
        this.winnerImage = winnerImage;
    }

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
