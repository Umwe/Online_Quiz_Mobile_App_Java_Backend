package com.mobile.app.Controller;

import com.mobile.app.Service.AuthResponse;
import com.mobile.app.Service.AuthService;
import com.mobile.app.Service.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mobile.app.Model.User;


@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request) {
        AuthResponse authResponse = authService.authenticateUser(request.getUsername(), request.getPassword());
        if (authResponse != null) {
            long userId = authResponse.getId(); // Retrieve user ID
            User user = authResponse.getUser();
            int role = authResponse.getRole();

            // Send response with user ID
            return ResponseEntity.ok("Login successful with userID: " + userId);
        }
        // Authentication failed or invalid credentials
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}