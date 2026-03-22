// RoomCategory.java (For the Room Type Form)
package org.example.hotel.model;

public class RoomCategory {
    private int id;
    private String name;
    private String description;

    public RoomCategory() {}
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}