package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hotel.service.RoomService;

import java.io.IOException;

@WebServlet("/admin/deleteRoom")
public class DeleteRoomServlet extends HttpServlet {

    private RoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. Get the Room ID from the URL parameter (e.g., deleteRoom?id=5)
            String idStr = request.getParameter("id");

            if (idStr != null && !idStr.isEmpty()) {
                int roomId = Integer.parseInt(idStr);

                // 2. Get the absolute path to the uploads directory
                // This is required so the Service can delete the physical image file
                String uploadPath = getServletContext().getRealPath("/uploads");

                // 3. Execute deletion via Service
                boolean success = roomService.deleteRoom(roomId, uploadPath);

                if (success) {
                    // Redirect back to the list with a success message (optional)
                    response.sendRedirect(request.getContextPath() + "/admin/room-list?message=deleted");
                } else {
                    response.getWriter().println("Failed to delete room. It might not exist or is linked to an active booking.");
                }
            } else {
                response.getWriter().println("Invalid Room ID provided.");
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Error: Room ID must be a number.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An unexpected error occurred: " + e.getMessage());
        }
    }
}