package org.example.hotel.service;

import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.PaymentDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Payment;
import org.example.hotel.model.Reservation;
import org.example.hotel.util.DBConnection;

import java.sql.Connection;
import java.time.LocalDateTime;

public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();
    private ReservationDAO reservationDAO = new ReservationDAO();
    private GuestDAO guestDAO = new GuestDAO();
    private InvoiceService invoiceService = new InvoiceService();

    public boolean makePayment(int reservationId, double amount, String method) {

        try (Connection con = DBConnection.getConnection()) {
            // Start transaction
            con.setAutoCommit(false);

            // 1. Create and Save the Payment Record
            Payment payment = new Payment();
            payment.setReservationId(reservationId);
            payment.setAmount(amount);
            payment.setMethod(method);
            payment.setPaymentDate(LocalDateTime.now());

            boolean paymentSaved = paymentDAO.savePayment(con, payment);
            if (!paymentSaved) throw new Exception("Failed to insert payment record.");

            // 2. Update the Reservation's Payment Status to 'PAID'
            boolean statusUpdated = paymentDAO.updatePaymentStatus(con, reservationId, "PAID");
            if (!statusUpdated) throw new Exception("Failed to update reservation payment status.");

            // Commit the database changes
            con.commit();

            // 3. Generate the PDF Invoice (External Action)
            // We fetch the latest data to ensure the PDF is accurate
            Reservation res = reservationDAO.getReservationById(reservationId);
            if (res != null) {
                Guest guest = guestDAO.getGuestById(res.getGuestId());
                if (guest != null) {
                    // Triggers the InvoiceService you already built!
                    invoiceService.generateInvoice(guest, res);
                }
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false; // If anything fails, it returns false to the Servlet
        }
    }
}