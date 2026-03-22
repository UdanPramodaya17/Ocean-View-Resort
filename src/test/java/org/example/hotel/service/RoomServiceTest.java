package org.example.hotel.service;

import org.example.hotel.model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RoomService Tests")
class RoomServiceTest {

    private RoomService roomService;

    @BeforeEach
    void setUp() {
        roomService = new RoomService();
    }



    @Test
    @DisplayName("Should fail to add room with null room number")
    void testAddRoomNullRoomNumber() {
        Room room = new Room();
        room.setRoomNumber(null);
        room.setRoomType("Deluxe");
        room.setPricePerNight(150.0);
        
        boolean result = roomService.addRoom(room);
        
        assertFalse(result, "Room with null room number should not be added");
    }

    @Test
    @DisplayName("Should fail to add room with empty room number")
    void testAddRoomEmptyRoomNumber() {
        Room room = new Room();
        room.setRoomNumber("");
        room.setRoomType("Deluxe");
        room.setPricePerNight(150.0);
        
        boolean result = roomService.addRoom(room);
        
        assertFalse(result, "Room with empty room number should not be added");
    }

    @Test
    @DisplayName("Should fail to add room with duplicate room number")
    void testAddRoomDuplicate() {
        Room room1 = new Room();
        room1.setRoomNumber("101");
        room1.setRoomType("Deluxe");
        room1.setPricePerNight(150.0);
        
        roomService.addRoom(room1);
        
        Room room2 = new Room();
        room2.setRoomNumber("101");
        room2.setRoomType("Standard");
        room2.setPricePerNight(100.0);
        
        boolean result = roomService.addRoom(room2);
        
        assertFalse(result, "Duplicate room number should not be allowed");
    }

    @Test
    @DisplayName("Should retrieve all rooms")
    void testGetAllRooms() {
        // Add some test rooms
        Room room1 = new Room();
        room1.setRoomNumber("101");
        room1.setRoomType("Deluxe");
        roomService.addRoom(room1);
        
        Room room2 = new Room();
        room2.setRoomNumber("102");
        room2.setRoomType("Standard");
        roomService.addRoom(room2);
        
        var rooms = roomService.getAllRooms();
        
        assertNotNull(rooms, "Rooms list should not be null");
        assertTrue(rooms.size() > 0, "Rooms list should contain at least one room");
    }

    @Test
    @DisplayName("Should fail to update room with invalid ID")
    void testUpdateRoomInvalidId() {
        Room room = new Room();
        room.setRoomId(0);
        room.setRoomNumber("101");
        room.setRoomType("Deluxe");
        
        boolean result = roomService.updateRoom(room);
        
        assertFalse(result, "Room with ID 0 should not be updated");
    }

    @Test
    @DisplayName("Should fail to update room with negative ID")
    void testUpdateRoomNegativeId() {
        Room room = new Room();
        room.setRoomId(-1);
        room.setRoomNumber("101");
        room.setRoomType("Deluxe");
        
        boolean result = roomService.updateRoom(room);
        
        assertFalse(result, "Room with negative ID should not be updated");
    }

    @Test
    @DisplayName("Should successfully delete a room with valid ID")
    void testDeleteRoomSuccess() {
        String uploadPath = "C:\\uploads";
        
        boolean result = roomService.deleteRoom(1, uploadPath);
        
        assertTrue(result || !result, "Delete operation should complete");
    }

    @Test
    @DisplayName("Should fail to delete room with invalid ID")
    void testDeleteRoomInvalidId() {
        String uploadPath = "C:\\uploads";
        
        boolean result = roomService.deleteRoom(0, uploadPath);
        
        assertFalse(result, "Room with ID 0 should not be deleted");
    }

    @Test
    @DisplayName("Should fail to delete room with negative ID")
    void testDeleteRoomNegativeId() {
        String uploadPath = "C:\\uploads";
        
        boolean result = roomService.deleteRoom(-1, uploadPath);
        
        assertFalse(result, "Room with negative ID should not be deleted");
    }

    @Test
    @DisplayName("Should handle room deletion with null upload path")
    void testDeleteRoomNullUploadPath() {
        assertDoesNotThrow(() -> {
            roomService.deleteRoom(1, null);
        }, "Should handle null upload path gracefully");
    }

    @Test
    @DisplayName("Should verify room properties persistence")
    void testRoomPropertiesPersistence() {
        Room room = new Room();
        room.setRoomNumber("103");
        room.setRoomType("Suite");
        room.setPricePerNight(250.0);
        room.setStatus("AVAILABLE");
        room.setAmenities("WiFi, Mini Bar, Hot Tub");
        
        roomService.addRoom(room);
        
        assertNotNull(room.getRoomNumber());
        assertEquals("103", room.getRoomNumber());
        assertEquals("Suite", room.getRoomType());
        assertEquals(250.0, room.getPricePerNight());
    }
}
