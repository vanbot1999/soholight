package com.soholighting.sohoTeam8.model;

public class Feedback {
        private String username;
        private String email;
        private String message;

    // 无参构造函数
    public Feedback() {
    }

    // 带所有属性的构造函数
    public Feedback(String username, String email, String message) {
        this.username = username;
        this.email = email;
        this.message = message;
    }

    // Getter 和 Setter 方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

