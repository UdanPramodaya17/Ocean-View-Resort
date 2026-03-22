package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;
import org.example.hotel.util.EmailSender;
import org.example.hotel.util.PDFGenerator;

import java.io.IOException;

@WebServlet("/superadmin/emailInvoice")
public class EmailInvoiceServlet extends HttpServlet {

    private ReservationDAO reservationDAO = new ReservationDAO();
    private GuestDAO guestDAO = new GuestDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int resId = Integer.parseInt(request.getParameter("resId"));
        Reservation res = reservationDAO.getReservationById(resId);
        Guest guest = guestDAO.getGuestById(res.getGuestId());

        if (res != null && guest != null) {
            String filePath = "invoices/invoice_" + res.getReservationNumber() + ".pdf";
            PDFGenerator.generateInvoice(filePath, guest, res);

            String subject = "Your Hotel Invoice - " + res.getReservationNumber();
            String message = "Dear " + guest.getFullName() + ",\n\nPlease find attached your hotel invoice.\n\nThank you!";

            boolean emailSent = EmailSender.sendEmailWithAttachment(
                    guest.getEmail(),
                    subject,
                    message,
                    filePath
            );

            if (emailSent) {
                response.getWriter().write("Invoice emailed successfully to " + guest.getEmail());
            } else {
                response.getWriter().write("Invoice generated but failed to send email.");
            }
        } else {
            response.getWriter().write("Reservation or Guest not found.");
        }
    }
}