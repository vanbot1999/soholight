package com.soholighting.sohoTeam8.model;

import java.util.List;

public class YearlyAwards {
    private String year;
    private List<Award> awards;

    // Constructor
    public YearlyAwards(String year, List<Award> awards) {
        this.year = year;
        this.awards = awards;
    }

    // Getters and setters
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public List<Award> getAwards() {
        return awards;
    }
    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }
}
