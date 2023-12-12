package com.soholighting.sohoTeam8.model;

import java.util.List;
import java.util.ArrayList;

public class YearlyAwards {
    // The year of the awards.
    private String year;
    // Categories of awards given out in this year.
    private List<YearlyAwardCategory> awardCategories;
    // Constructor for creating an instance with year and list of award categories.
    public YearlyAwards(String year, List<YearlyAwardCategory> awardCategories) {
        this.year = year;
        this.awardCategories = awardCategories;
    }
    // Constructor for creating an instance with only the year.
    public YearlyAwards(String year) {
        this.year = year;
        this.awardCategories = new ArrayList<>();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<YearlyAwardCategory> getAwardCategories() {
        return awardCategories;
    }

    public void setAwardCategories(List<YearlyAwardCategory> awardCategories) {
        this.awardCategories = awardCategories;
    }
}
