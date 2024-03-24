package com.mobile.app.Service;

import com.mobile.app.Model.User;

public class AuthResponse {
    private User user;
    private int role;
    private long id; // Add user ID field

    public AuthResponse() {
    }

    public AuthResponse(User user, int role, long id) {
        this.user = user;
        this.role = role;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}