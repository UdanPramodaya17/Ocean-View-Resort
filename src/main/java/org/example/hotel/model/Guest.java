package org.example.hotel.model;



public class Guest {

    private int guestId;
    private String fullName;
    private String address;
    private String contactNumber;
    private String email;

    public Guest() {}

    public Guest(int guestId, String fullName, String address,
                 String contactNumber, String email) {
        this.guestId = guestId;
        this.fullName = fullName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    // Getters
    public int getGuestId() {
        return guestId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}