package com.mobile.app.Service;

import com.mobile.app.Model.User;

public class AuthResponse {
    private User user;
    private int role;

    public AuthResponse() {
    }

    public AuthResponse(User user, int role) {
        this.user = user;
        this.role = role;
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
}