package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Room;
import org.example.hotel.service.RoomService;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/room-list")
public class RoomListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RoomDAO dao = new RoomDAO();
        List<Room> rooms = dao.getAllRooms(); // Ensure your DAO fetches the new columns!

        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("/WEB-INF/admin/room-list.jsp").forward(request, response);
    }
}