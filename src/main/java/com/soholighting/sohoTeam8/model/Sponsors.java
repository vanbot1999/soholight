package com.soholighting.sohoTeam8.model;
public class Sponsors {
    private String name;
    private String alt;
    private String image;

    public Sponsors(String name, String alt, String image) {
        this.name = name;
        this.alt = alt;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAlt() {
        return alt;
    }
    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
