package org.example.hotel.controller;




import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import org.example.hotel.model.Room;
import org.example.hotel.service.RoomService;

import java.io.*;
import java.nio.file.Paths;

@MultipartConfig
public class AddRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String roomNumber = request.getParameter("roomNumber");
        String roomType = request.getParameter("roomType");
        double price = Double.parseDouble(request.getParameter("price"));
        String amenities = request.getParameter("amenities");

        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName())
                .getFileName().toString();

        String uploadPath = getServletContext().getRealPath("/uploads");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        filePart.write(uploadPath + File.separator + fileName);

        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setRoomType(roomType);
        room.setPricePerNight(price);
        room.setAmenities(amenities);
        room.setImagePath("uploads/" + fileName);
        room.setStatus("AVAILABLE");

        RoomService service = new RoomService();

        if (service.addRoom(room)) {
            response.sendRedirect("jsp/admin/room-list.jsp");
        } else {
            response.getWriter().println("Error Adding Room");
        }
    }
}