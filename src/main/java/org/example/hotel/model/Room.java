package org.example.hotel.model;


public class Room {

    private int roomId;
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private String amenities;
    private String imagePath;
    private String status;
    private int quantity;
    private int maxAdults;
    private int maxChildren;
    private String description;


    public Room() {}

    public Room(int roomId, String roomNumber, String roomType,
                double pricePerNight, String amenities,
                String imagePath, String status) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        this.imagePath = imagePath;
        this.status = status;
    }

    // Getters
    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getStatus() {
        return status;
    }

    public int getQuantity() { return quantity; }

    public int getMaxAdults() { return maxAdults; }

    public int getMaxChildren() { return maxChildren; }

    public String getDescription() { return description; }




    // Setters
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setMaxAdults(int maxAdults) { this.maxAdults = maxAdults; }

    public void setMaxChildren(int maxChildren) { this.maxChildren = maxChildren; }

    public void setDescription(String description) { this.description = description; }



}