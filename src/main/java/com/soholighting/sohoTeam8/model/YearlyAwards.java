package com.soholighting.sohoTeam8.model;

import java.util.List;
import java.util.ArrayList;

public class YearlyAwards {
    private String year;
    private List<YearlyAwardCategory> awardCategories;

    public YearlyAwards(String year, List<YearlyAwardCategory> awardCategories) {
        this.year = year;
        this.awardCategories = awardCategories;
    }
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
