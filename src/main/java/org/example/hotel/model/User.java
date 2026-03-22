package org.example.hotel.model;

public class User {

    private int userId;
    private String fullName; // Added
    private String username;
    private String password;
    private String address;  // Changed from email
    private String role;
    private String status;

    public User() {}

    public User(int userId, String fullName, String username, String password, String address, String role, String status) {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.role = role;
        this.status = status;
    }

    // Getters
    public int getUserId() { return userId; }
    public String getFullName() { return fullName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getAddress() { return address; }
    public String getRole() { return role; }
    public String getStatus() { return status; }

    // Setters
    public void setUserId(int userId) { this.userId = userId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setAddress(String address) { this.address = address; }
    public void setRole(String role) { this.role = role; }
    public void setStatus(String status) { this.status = status; }
}