package org.example.hotel.controller;//package org.example.hotel.controller;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.hotel.dao.AdminDAO;
//import org.example.hotel.model.Facility;
//
//import java.io.IOException;
//
//@WebServlet("/admin/addFacility")
//public class AddFacilityServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("facilityName");
//        String desc = request.getParameter("facilityDesc");
//
//        Facility f = new Facility();
//        f.setName(name);
//        f.setDescription(desc);
//
//        AdminDAO dao = new AdminDAO();
//        if(dao.addFacility(f)) {
//            response.sendRedirect("facility-list.jsp");
//        } else {
//            response.getWriter().println("Error adding facility");
//        }
//    }
//}


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hotel.dao.AdminDAO;
import org.example.hotel.model.Facility;

import java.io.IOException;

@WebServlet("/admin/addFacility")
public class AddFacilityServlet extends HttpServlet {

    // ✅ THIS IS MISSING
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/admin/addFacility.jsp")
                .forward(request, response);
    }

    // POST (already correct)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("facilityName");
        String desc = request.getParameter("facilityDesc");

        Facility f = new Facility();
        f.setName(name);
        f.setDescription(desc);

        AdminDAO dao = new AdminDAO();

        if (dao.addFacility(f)) {
            response.sendRedirect(request.getContextPath() + "/admin/dashboard");
        } else {
            response.getWriter().println("Error adding facility");
        }
    }
}