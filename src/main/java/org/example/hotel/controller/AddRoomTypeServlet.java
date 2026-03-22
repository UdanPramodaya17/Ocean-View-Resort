package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hotel.dao.AdminDAO;
import org.example.hotel.model.RoomCategory;

import java.io.IOException;

@WebServlet("/admin/addRoomType")
public class AddRoomTypeServlet extends HttpServlet {

    // ✅ ADD THIS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/admin/addRoomType.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("typeName");
        String desc = request.getParameter("typeDesc");

        RoomCategory cat = new RoomCategory();
        cat.setName(name);
        cat.setDescription(desc);

        AdminDAO dao = new AdminDAO();

        if (dao.addRoomCategory(cat)) {
            response.sendRedirect(request.getContextPath() + "/admin/dashboard");
        } else {
            response.getWriter().println("Error adding room category");
        }
    }
}