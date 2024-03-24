package com.mobile.app.Service;

import com.mobile.app.Model.User;

public class AuthResponse {
    private User user;
    private int role;
    private long userId; // Add user ID field

    public AuthResponse() {
    }

    public AuthResponse(User user, int role, long userId) {
        this.user = user;
        this.role = role;
        this.userId = userId;
    }

    public AuthResponse(User user, int role) {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}


