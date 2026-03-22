package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;
import org.example.hotel.util.PDFGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/admin/downloadInvoice")
public class DownloadInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resIdParam = request.getParameter("resId");
        if (resIdParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing Reservation ID");
            return;
        }

        int reservationId = Integer.parseInt(resIdParam);

        // 1. Fetch Data from Database
        // Assuming you have these DAOs and methods available
        ReservationDAO resDAO = new ReservationDAO();
        GuestDAO guestDAO = new GuestDAO();

        Reservation reservation = resDAO.getReservationById(reservationId);
        if (reservation == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Reservation not found");
            return;
        }

        Guest guest = guestDAO.getGuestById(reservation.getGuestId());

        // 2. Prepare File Path
        String fileName = "Invoice_" + reservation.getReservationNumber() + ".pdf";
        String folderPath = getServletContext().getRealPath("/WEB-INF/invoices/");

        File folder = new File(folderPath);
        if (!folder.exists()) folder.mkdirs(); // Create directory if it doesn't exist

        String filePath = folderPath + File.separator + fileName;

        // 3. Generate the PDF
        PDFGenerator.generateInvoice(filePath, guest, reservation);

        // 4. Send File to Browser
        File downloadFile = new File(filePath);
        if (downloadFile.exists()) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.setContentLength((int) downloadFile.length());

            try (FileInputStream inStream = new FileInputStream(downloadFile);
                 OutputStream outStream = response.getOutputStream()) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to generate PDF");
        }
    }
}