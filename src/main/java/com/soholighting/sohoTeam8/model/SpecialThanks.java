package com.soholighting.sohoTeam8.model;

public class SpecialThanks {
    private String name;
    private String URL;
    private String thanks_logo;
    private int thanks_id;

    public SpecialThanks(int thanks_id,String name, String URL, String thanks_logo) {
        this.thanks_id = thanks_id;
        this.name = name;
        this.URL = URL;
        this.thanks_logo = thanks_logo;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getThanks_logo() {
        return thanks_logo;
    }

    public void setThanks_logo(String thanks_logo) {
        this.thanks_logo = thanks_logo;
    }

    public int getThanks_id() {
        return thanks_id;
    }

    public void setThanks_id(int thanks_id) {
        this.thanks_id = thanks_id;
    }
}
