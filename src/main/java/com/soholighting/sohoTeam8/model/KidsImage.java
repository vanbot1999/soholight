package com.soholighting.sohoTeam8.model;

public class KidsImage {
    private int img_id;
    private String name;
    private int age;
    private String description;

    private  String url;
    private  String sourceUrl;
    private  String issueDate;

    public KidsImage(int id, String name, int age, String description, String url, String sourceUrl, String issueDate) {
        this.img_id = id;
        this.name = name;
        this.age = age;
        this.description = description;

        this.url = url;
        this.sourceUrl = sourceUrl;
        this.issueDate = issueDate;
    }


    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getId() {
        return img_id;
    }

    public void setId(int id) {
        this.img_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
