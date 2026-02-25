package org.example.hotel.controller;



import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.hotel.service.RoomService;

import java.io.IOException;

public class RoomListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        RoomService service = new RoomService();
        request.setAttribute("rooms", service.getAllRooms());

        request.getRequestDispatcher("jsp/admin/room-list.jsp")
                .forward(request, response);
    }
}
