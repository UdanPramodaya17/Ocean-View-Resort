package org.example.hotel.service;

import org.example.hotel.dao.UserDAO;
import org.example.hotel.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public boolean registerReceptionUser(String username, String password) {

        // Check if username already exists
        User existing = userDAO.getUserByUsername(username);
        if (existing != null) {
            return false; // username taken
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // later you can hash this
        user.setRole("RECEPTION");
        user.setStatus("ACTIVE");

        return userDAO.saveUser(user);
    }
}

