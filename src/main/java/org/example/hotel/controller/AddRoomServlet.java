////package org.example.hotel.controller;
////
////import jakarta.servlet.ServletException;
////import jakarta.servlet.annotation.MultipartConfig;
////import jakarta.servlet.annotation.WebServlet;
////import jakarta.servlet.http.*;
////import org.example.hotel.model.Room;
////import org.example.hotel.service.RoomService;
////
////import java.io.File;
////import java.io.IOException;
////import java.nio.file.Paths;
////
////@WebServlet("/admin/addRoom")
////@MultipartConfig
////public class AddRoomServlet extends HttpServlet {
////
////    @Override
////    protected void doPost(HttpServletRequest request,
////                          HttpServletResponse response)
////            throws ServletException, IOException {
////
////        try {
////
////            // 1️⃣ Get form values
////            String roomNumber = request.getParameter("roomNumber");
////            String roomType = request.getParameter("roomType");
////            String priceStr = request.getParameter("price");
////            String amenities = request.getParameter("amenities");
////            String quantityStr = request.getParameter("quantity");
////
////            // Validation
////            if (roomNumber == null || roomType == null ||
////                    priceStr == null || quantityStr == null ||
////                    roomNumber.isEmpty() || roomType.isEmpty() ||
////                    priceStr.isEmpty() || quantityStr.isEmpty()) {
////
////                response.getWriter().println("All required fields must be filled!");
////                return;
////            }
////
////            double price = Double.parseDouble(priceStr);
////            int quantity = Integer.parseInt(quantityStr);
////
////            // 2️⃣ Handle Image Upload
////            Part filePart = request.getPart("image");
////            String imagePath = null;
////
////            if (filePart != null && filePart.getSize() > 0) {
////
////                String fileName = Paths.get(filePart.getSubmittedFileName())
////                        .getFileName().toString();
////
////                String uploadPath = getServletContext().getRealPath("/uploads");
////                File uploadDir = new File(uploadPath);
////                if (!uploadDir.exists()) uploadDir.mkdir();
////
////                filePart.write(uploadPath + File.separator + fileName);
////
////                imagePath = "uploads/" + fileName;   // ✅ CORRECT
////            }
////
////            // 3️⃣ Create Room Object
////            Room room = new Room();
////            room.setRoomNumber(roomNumber);
////            room.setRoomType(roomType);
////            room.setPricePerNight(price);
////            room.setAmenities(amenities);
////            room.setStatus("AVAILABLE");
////            room.setQuantity(quantity);
////            room.setImagePath(imagePath);
////
////            // 4️⃣ Save
////            RoomService service = new RoomService();
////            boolean success = service.addRoom(room);
////
////            if (success) {
////                response.sendRedirect(request.getContextPath() + "/admin/room-list");
////            } else {
////                response.getWriter().println("Room number already exists!");
////            }
////
////        } catch (NumberFormatException e) {
////            response.getWriter().println("Invalid number format!");
////        } catch (Exception e) {
////            e.printStackTrace();
////            response.getWriter().println("Error adding room: " + e.getMessage());
////        }
////    }
////}
//
//
//
//package org.example.hotel.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//import org.example.hotel.model.Room;
//import org.example.hotel.service.RoomService;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Paths;
//
//@WebServlet("/admin/addRoom")
//@MultipartConfig
//public class AddRoomServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request,
//                          HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//            // 1️⃣ Get updated form values based on the image labels
//            String roomName = request.getParameter("roomName"); // Image calls it "Room Name"
//            String roomType = request.getParameter("roomType");
//            String fareStr = request.getParameter("roomFare");  // Image calls it "Room Fare"
//            String bedsStr = request.getParameter("numBeds");   // New field: Number of Beds
//            String adultsStr = request.getParameter("maxAdults");
//            String childStr = request.getParameter("maxChild");
//            String description = request.getParameter("description");
//
//            // 2️⃣ Handle Multiple Checkboxes for Facilities
//            String[] amenitiesArray = request.getParameterValues("facilities");
//            String amenities = (amenitiesArray != null) ? String.join(", ", amenitiesArray) : "";
//
//            // 3️⃣ Basic Validation
//            if (roomName == null || roomType == null || fareStr == null ||
//                    roomName.isEmpty() || roomType.isEmpty() || fareStr.isEmpty()) {
//                response.getWriter().println("All required fields (*) must be filled!");
//                return;
//            }
//
//            // Parsing numbers
//            double price = Double.parseDouble(fareStr);
//            int maxAdults = (adultsStr != null) ? Integer.parseInt(adultsStr) : 1;
//            int maxChild = (childStr != null) ? Integer.parseInt(childStr) : 0;
//            // Note: If you still use 'quantity' in your logic, fetch it here as well.
//
//            // 4️⃣ Handle Image Upload (Field name "roomImage" from the form)
//            Part filePart = request.getPart("roomImage");
//            String imagePath = null;
//
//            if (filePart != null && filePart.getSize() > 0) {
//                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//                String uploadPath = getServletContext().getRealPath("/uploads");
//
//                File uploadDir = new File(uploadPath);
//                if (!uploadDir.exists()) uploadDir.mkdir();
//
//                filePart.write(uploadPath + File.separator + fileName);
//                imagePath = "uploads/" + fileName;
//            }
//
//            // 5️⃣ Create and Populate Room Object
//            Room room = new Room();
//            room.setRoomNumber(roomName); // Using Name as Number if that's your unique ID
//            room.setRoomType(roomType);
//            room.setPricePerNight(price);
//            room.setAmenities(amenities);
//            room.setMaxAdults(maxAdults);
//            room.setMaxChildren(maxChild);
//            room.setDescription(description);
//            room.setImagePath(imagePath);
//            room.setStatus("AVAILABLE");
//            room.setQuantity(1); // Defaulting to 1 based on the new form layout
//
//            // 6️⃣ Save via Service
//            RoomService service = new RoomService();
//            boolean success = service.addRoom(room);
//
//            if (success) {
//                response.sendRedirect(request.getContextPath() + "/admin/room-list");
//            } else {
//                response.getWriter().println("Error: Could not save room. Room name/number might already exist.");
//            }
//
//        } catch (NumberFormatException e) {
//            response.getWriter().println("Invalid number format in Fare, Adults, or Children fields!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().println("Error adding room: " + e.getMessage());
//        }
//    }
//}

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

    /**
     * This method loads the Add Room page when you navigate to the URL.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/addRoom.jsp").forward(request, response);
    }

    /**
     * This method handles the form submission (Saving the room).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1️⃣ Get values from addRoom.jsp
            String roomName = request.getParameter("roomName");
            String roomType = request.getParameter("roomType");
            String fareStr = request.getParameter("roomFare");
            String adultsStr = request.getParameter("maxAdults");
            String childStr = request.getParameter("maxChild");
            String description = request.getParameter("description");

            // 2️⃣ Handle Checkboxes (In your JSP the name is "amenities")
            String[] amenitiesArray = request.getParameterValues("amenities");
            String amenities = (amenitiesArray != null) ? String.join(", ", amenitiesArray) : "";

            // 3️⃣ Basic Validation
            if (roomName == null || roomType == null || fareStr == null ||
                    roomName.isEmpty() || roomType.isEmpty() || fareStr.isEmpty()) {
                response.getWriter().println("All required fields (*) must be filled!");
                return;
            }

            // Parsing numbers safely
            double price = Double.parseDouble(fareStr);
            int maxAdults = (adultsStr != null && !adultsStr.isEmpty()) ? Integer.parseInt(adultsStr) : 1;
            int maxChild = (childStr != null && !childStr.isEmpty()) ? Integer.parseInt(childStr) : 0;

            // 4️⃣ Handle Image Upload (Field name "roomImage" from addRoom.jsp)
            Part filePart = request.getPart("roomImage");
            String imagePath = null;

            if (filePart != null && filePart.getSize() > 0) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

// Remove double extensions like .jpg.jpg
                if (fileName.toLowerCase().endsWith(".jpg.jpg")) {
                    fileName = fileName.replace(".jpg.jpg", ".jpg");
                }
                String uploadPath = getServletContext().getRealPath("/uploads");

                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdir();

                filePart.write(uploadPath + File.separator + fileName);
                imagePath = "uploads/" + fileName;
            }

            // 5️⃣ Create and Populate Room Object
            Room room = new Room();
            room.setRoomNumber(roomName);
            room.setRoomType(roomType);
            room.setPricePerNight(price);
            room.setAmenities(amenities);
            room.setMaxAdults(maxAdults);
            room.setMaxChildren(maxChild);
            room.setDescription(description);
            room.setImagePath(imagePath);
            room.setStatus("AVAILABLE");
            room.setQuantity(1);

            // 6️⃣ Save via Service
            RoomService service = new RoomService();
            boolean success = service.addRoom(room);

            if (success) {
                // Successfully saved! Go to the list.
                response.sendRedirect(request.getContextPath() + "/admin/room-list");
            } else {
                response.getWriter().println("Error: Room name/number already exists in database.");
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid number format! Please check Fare, Adults, and Children fields.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error adding room: " + e.getMessage());
        }
    }
}