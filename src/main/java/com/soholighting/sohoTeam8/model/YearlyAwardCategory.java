package com.soholighting.sohoTeam8.model;

import java.util.List;
// Represents a category of awards given out in a particular year.
public class YearlyAwardCategory {
    // Title of the award category.
    private String categoryTitle;
    // List of awards in this category.
    private List<Award> awards;
    // Constructor for creating an instance with category title and list of awards.
    public YearlyAwardCategory(String categoryTitle, List<Award> awards) {
        this.categoryTitle = categoryTitle;
        this.awards = awards;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }
}
