package com.mobile.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mobile.app.Model.User;
import com.mobile.app.Repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthResponse authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful, return user details and role
            return new AuthResponse(user, user.getRole());
        }
        return null; // Authentication failed
    }
}