package com.soholighting.sohoTeam8.model;

import java.util.List;

public class YearlyAwardCategory {
    private String categoryTitle;
    private List<Award> awards;

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
