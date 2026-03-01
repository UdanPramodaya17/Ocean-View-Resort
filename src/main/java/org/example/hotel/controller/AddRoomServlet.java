package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.model.Room;
import org.example.hotel.service.RoomService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/admin/addRoom")
@MultipartConfig
public class AddRoomServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // 1️⃣ Get form values
            String roomNumber = request.getParameter("roomNumber");
            String roomType = request.getParameter("roomType");
            String priceStr = request.getParameter("price");
            String amenities = request.getParameter("amenities");
            String quantityStr = request.getParameter("quantity");

            // Validation
            if (roomNumber == null || roomType == null ||
                    priceStr == null || quantityStr == null ||
                    roomNumber.isEmpty() || roomType.isEmpty() ||
                    priceStr.isEmpty() || quantityStr.isEmpty()) {

                response.getWriter().println("All required fields must be filled!");
                return;
            }

            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            // 2️⃣ Handle Image Upload
            Part filePart = request.getPart("image");
            String imagePath = null;

            if (filePart != null && filePart.getSize() > 0) {

                String fileName = Paths.get(filePart.getSubmittedFileName())
                        .getFileName().toString();

                String uploadPath = getServletContext().getRealPath("/uploads");
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdir();

                filePart.write(uploadPath + File.separator + fileName);

                imagePath = "uploads/" + fileName;   // ✅ CORRECT
            }

            // 3️⃣ Create Room Object
            Room room = new Room();
            room.setRoomNumber(roomNumber);
            room.setRoomType(roomType);
            room.setPricePerNight(price);
            room.setAmenities(amenities);
            room.setStatus("AVAILABLE");
            room.setQuantity(quantity);
            room.setImagePath(imagePath);

            // 4️⃣ Save
            RoomService service = new RoomService();
            boolean success = service.addRoom(room);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/admin/room-list");
            } else {
                response.getWriter().println("Room number already exists!");
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid number format!");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error adding room: " + e.getMessage());
        }
    }
}