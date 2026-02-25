package org.example.hotel.service;


import org.example.hotel.dao.UserDAO;
import org.example.hotel.model.User;
import org.example.hotel.util.PasswordUtil;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {

        User user = userDAO.getUserByUsername(username);

        if (user != null
                && user.getStatus().equals("ACTIVE")
                && PasswordUtil.checkPassword(password, user.getPassword())) {
            return user;
        }

        return null;
    }
}