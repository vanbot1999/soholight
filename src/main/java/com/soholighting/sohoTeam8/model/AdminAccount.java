package com.soholighting.sohoTeam8.model;

public class AdminAccount {
    private int user_id;
    private String username;
    private String password;


    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername(){
        return  username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

