package org.example.hotel.service;

import org.example.hotel.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService Tests")
class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }


    @Test
    @DisplayName("Should fail registration when username already exists")
    void testRegisterReceptionUserDuplicate() {
        // First registration should succeed
        userService.registerReceptionUser("existing_user", "password123");
        
        // Second registration with same username should fail
        boolean result = userService.registerReceptionUser("existing_user", "different_password");
        
        assertFalse(result, "Registration should fail with duplicate username");
    }




    @Test
    @DisplayName("Should fail admin registration when username already exists")
    void testRegisterAdminUserDuplicate() {
        // First registration should succeed
        userService.registerAdminUser("existing_admin", "password123");
        
        // Second registration with same username should fail
        boolean result = userService.registerAdminUser("existing_admin", "different_password");
        
        assertFalse(result, "Admin registration should fail with duplicate username");
    }



    @Test
    @DisplayName("Should handle null username in reception registration")
    void testRegisterReceptionNullUsername() {
        // Null username should be handled gracefully
        assertDoesNotThrow(() -> {
            userService.registerReceptionUser(null, "password123");
        }, "Should handle null username without throwing exception");
    }

    @Test
    @DisplayName("Should handle empty username in reception registration")
    void testRegisterReceptionEmptyUsername() {
        boolean result = userService.registerReceptionUser("", "password123");
        
        assertFalse(result, "Empty username should be invalid");
    }





    @Test
    @DisplayName("Reception and Admin users should not share same username")
    void testReceptionAdminUsernameConflict() {
        // Register reception user
        userService.registerReceptionUser("dual_user", "password123");
        
        // Try to register admin user with same username
        boolean result = userService.registerAdminUser("dual_user", "different_password");
        
        assertFalse(result, "Admin registration should fail when username exists as reception");
    }
}
