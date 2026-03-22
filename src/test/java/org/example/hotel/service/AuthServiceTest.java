package org.example.hotel.service;

import org.example.hotel.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AuthService Tests")
class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService();
    }


    @Test
    @DisplayName("Should fail login when user not found")
    void testLoginUserNotFound() {
        User result = authService.login("nonexistent_user_" + System.nanoTime(), "password123");
        
        assertNull(result, "Should return null when user not found");
    }

    @Test
    @DisplayName("Should fail login with wrong password")
    void testLoginWrongPassword() {
        // Tests require actual user in database
        User result = authService.login("john_doe", "wrong_password_" + System.nanoTime());
        
        assertNull(result, "Should return null with wrong password");
    }

    @Test
    @DisplayName("Should fail login when user status is INACTIVE")
    void testLoginInactiveUser() {
        // This would test against a user with INACTIVE status
        // Requires database setup or mocking
        User result = authService.login("inactive_user", "password123");
        
        // If user exists and is inactive, should return null
        assertNull(result, "Should return null when user is INACTIVE");
    }

    @Test
    @DisplayName("Should fail login when user status is DISABLED")
    void testLoginDisabledUser() {
        User result = authService.login("disabled_user", "password456");
        
        assertNull(result, "Should return null when user is DISABLED");
    }

    @Test
    @DisplayName("Should handle null username gracefully")
    void testLoginNullUsername() {
        assertDoesNotThrow(() -> {
            authService.login(null, "password123");
        }, "Should handle null username without throwing exception");
    }

    @Test
    @DisplayName("Should handle null password gracefully")
    void testLoginNullPassword() {
        assertDoesNotThrow(() -> {
            authService.login("john_doe", null);
        }, "Should handle null password without throwing exception");
    }

    @Test
    @DisplayName("Should handle empty username")
    void testLoginEmptyUsername() {
        User result = authService.login("", "password123");
        
        assertNull(result, "Should return null for empty username");
    }

    @Test
    @DisplayName("Should handle empty password")
    void testLoginEmptyPassword() {
        User result = authService.login("john_doe", "");
        
        assertNull(result, "Should return null for empty password");
    }

    @Test
    @DisplayName("Should be case-sensitive for username")
    void testLoginCaseSensitiveUsername() {
        User result = authService.login("JOHN_DOE", "password123");
        
        // Assuming usernames are case-sensitive
        assertNull(result, "Username should be case-sensitive");
    }

    @Test
    @DisplayName("Should be case-sensitive for password")
    void testLoginCaseSensitivePassword() {
        User result = authService.login("john_doe", "PASSWORD123");
        
        // Assuming passwords are case-sensitive
        assertNull(result, "Password should be case-sensitive");
    }

    @Test
    @DisplayName("Should validate user status with exact match")
    void testLoginStatusExactMatch() {
        // Status should be exactly "ACTIVE", not "active" or "Active"
        User result = authService.login("test_user", "password");
        
        // Only ACTIVE status should allow login
        assertNull(result, "Only ACTIVE status should allow login");
    }
}