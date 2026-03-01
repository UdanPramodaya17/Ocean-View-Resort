package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;
import org.example.hotel.util.PDFGenerator;

import java.io.IOException;

@WebServlet("/superadmin/downloadInvoice")
public class DownloadInvoiceServlet extends HttpServlet {

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

            // Set response headers to download PDF
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=invoice_" + res.getReservationNumber() + ".pdf");

            java.nio.file.Files.copy(java.nio.file.Paths.get(filePath), response.getOutputStream());
        } else {
            response.getWriter().write("Invoice generation failed: Reservation or Guest not found.");
        }
    }
}