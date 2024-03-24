package com.mobile.app.Service;

import com.mobile.app.Model.User;

public interface AuthService {
    AuthResponse authenticateUser(String username, String password);
}
