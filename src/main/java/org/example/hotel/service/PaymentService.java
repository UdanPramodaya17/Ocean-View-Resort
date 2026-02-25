package org.example.hotel.service;

import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.PaymentDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Payment;
import org.example.hotel.model.Reservation;
import org.example.hotel.util.PDFGenerator;

import java.time.LocalDateTime;

public class PaymentService {

    private final PaymentDAO paymentDAO = new PaymentDAO();
    private final ReservationDAO reservationDAO = new ReservationDAO();
    private final GuestDAO guestDAO = new GuestDAO();

    public boolean makePayment(int reservationId, double amount, String method) {

        try {
            // 1️⃣ Create Payment object
            Payment payment = new Payment();
            payment.setReservationId(reservationId);
            payment.setAmount(amount);
            payment.setMethod(method);
            payment.setPaymentDate(LocalDateTime.now());

            // 2️⃣ Save Payment
            boolean saved = paymentDAO.savePayment(payment);
            if (!saved) {
                System.out.println("Payment saving failed!");
                return false;
            }

            // 3️⃣ Fetch Reservation & Guest
            Reservation reservation = reservationDAO.getReservationById(reservationId);
            if (reservation == null) {
                System.out.println("Reservation not found!");
                return false;
            }

            Guest guest = guestDAO.getGuestById(reservation.getGuestId());
            if (guest == null) {
                System.out.println("Guest not found!");
                return false;
            }

            // 4️⃣ Generate PDF Invoice
            String filePath = "invoices/invoice_" + reservation.getReservationNumber() + ".pdf";
            PDFGenerator.generateInvoice(filePath, guest, reservation);

            System.out.println("Payment successful & invoice generated at: " + filePath);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}