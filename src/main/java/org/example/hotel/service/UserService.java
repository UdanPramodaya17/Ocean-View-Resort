package org.example.hotel.service;

import org.example.hotel.dao.UserDAO;
import org.example.hotel.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public boolean registerReceptionUser(String fullName, String username, String password, String address) {
        User existing = userDAO.getUserByUsername(username);
        if (existing != null) {
            return false; // username taken
        }

        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setRole("RECEPTION");
        user.setStatus("ACTIVE");

        return userDAO.saveUser(user);
    }

    public boolean registerAdminUser(String fullName, String username, String password, String address) {
        User existing = userDAO.getUserByUsername(username);
        if (existing != null) {
            return false;
        }

        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setRole("ADMIN");
        user.setStatus("ACTIVE");

        return userDAO.saveUser(user);
    }
}