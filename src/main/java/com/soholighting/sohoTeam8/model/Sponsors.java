package com.soholighting.sohoTeam8.model;
public class Sponsors {
    private int Sponsor_id;//id
    private String name;//name
    private String URL;//sponsor's website url
    private String sponsor_logo; //sponsor logo
//constructor
    public Sponsors(int sponsor_id,String name, String URL, String sponsor_logo) {
        this.Sponsor_id = sponsor_id;
        this.name = name;
        this.URL = URL;
        this.sponsor_logo = sponsor_logo;

    }
//empty constructor
    public Sponsors() {

    }
//getters and setters
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

    public String getSponsor_logo() {
        return sponsor_logo;
    }

    public void setSponsor_logo(String sponsor_logo) {
        this.sponsor_logo = sponsor_logo;
    }

    public int getSponsor_id() {
        return Sponsor_id;
    }

    public void setSponsor_id(int sponsor_id) {
        this.Sponsor_id = sponsor_id;
    }
}

