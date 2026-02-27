package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.dao.RoomDAO;
import org.example.hotel.model.Reservation;
import org.example.hotel.model.Room;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/reception/edit")
public class EditReservationServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();
    private GuestDAO guestDAO = new GuestDAO();
    private RoomDAO roomDAO = new RoomDAO();

    // 1️⃣ GET: Load data into the form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Reservation res = reservationDAO.getReservationById(id);

            if (res != null) {
                // Enrich data for the form
                res.setGuestName(guestDAO.getGuestNameById(res.getGuestId()));
                res.setRoomType(roomDAO.getRoomTypeById(res.getRoomId()));

                request.setAttribute("reservation", res);
                request.getRequestDispatcher("/WEB-INF/reception/editReservation.jsp").forward(request, response);
            } else {
                response.sendRedirect("reservations?error=NotFound");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("reservations?error=InvalidId");
        }
    }

    // 2️⃣ POST: Update the data in DB
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int resId = Integer.parseInt(request.getParameter("reservationId"));
            String newGuestName = request.getParameter("guestName");
            String newRoomType = request.getParameter("roomType");
            LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
            LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));

            // 1. Get current reservation to find the Guest ID
            Reservation currentRes = reservationDAO.getReservationById(resId);

            // 2. Update Guest Name
            guestDAO.updateGuestName(currentRes.getGuestId(), newGuestName);

            // 3. Find a room of the NEW type (or same type)
            Room room = roomDAO.getFirstAvailableRoom(newRoomType, checkIn, checkOut);

            if (room != null) {
                // 4. Update Reservation with NEW room and dates
                boolean success = reservationDAO.updateReservationDetails(resId, room.getRoomId(), checkIn, checkOut);

                if (success) {
                    response.sendRedirect(request.getContextPath() + "/reception/reservations?success=updated");
                } else {
                    throw new Exception("Database update failed.");
                }
            } else {
                request.setAttribute("error", "No " + newRoomType + " rooms available for these dates!");
                doGet(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("reservations?error=UpdateFailed");
        }
    }
}