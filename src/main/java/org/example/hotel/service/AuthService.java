//package org.example.hotel.service;
//
//
//import org.example.hotel.dao.UserDAO;
//import org.example.hotel.model.User;
//import org.example.hotel.util.PasswordUtil;
//
//public class AuthService {
//
//    private UserDAO userDAO = new UserDAO();
//
//    public User login(String username, String password) {
//
//        User user = userDAO.getUserByUsername(username);
//
//        if (user != null
//                && user.getStatus().equals("ACTIVE")
//                && PasswordUtil.checkPassword(password, user.getPassword())) {
//            return user;
//        }
//
//        return null;
//    }
//}

package org.example.hotel.service;

import org.example.hotel.dao.UserDAO;
import org.example.hotel.model.User;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {

        User user = userDAO.getUserByUsername(username);

        if (user == null) {
            return null; // user not found
        }

        // 1️⃣ Check password
        if (!user.getPassword().equals(password)) {
            return null; // wrong password
        }

        // 2️⃣ Check user status
        if (!"ACTIVE".equalsIgnoreCase(user.getStatus())) {
            return null; // user disabled
        }

        return user; // login success
    }
}