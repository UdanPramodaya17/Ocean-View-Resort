package org.example.hotel.service;

import org.example.hotel.dao.GuestDAO;
import org.example.hotel.dao.PaymentDAO;
import org.example.hotel.dao.ReservationDAO;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Payment;
import org.example.hotel.model.Reservation;
import org.example.hotel.util.EmailSender;
import org.example.hotel.util.PDFGenerator;

import java.time.LocalDateTime;

public class PaymentService {

    private final PaymentDAO paymentDAO = new PaymentDAO();
    private final ReservationDAO reservationDAO = new ReservationDAO();
    private final GuestDAO guestDAO = new GuestDAO();

//    public boolean makePayment(int reservationId, double amount, String method) {
//
//        try {
//            // 1️⃣ Create Payment object
//            Payment payment = new Payment();
//            payment.setReservationId(reservationId);
//            payment.setAmount(amount);
//            payment.setMethod(method);
//            payment.setPaymentDate(LocalDateTime.now());
//
//            // 2️⃣ Save Payment
//            boolean saved = paymentDAO.savePayment(payment);
//            if (!saved) {
//                System.out.println("Payment saving failed!");
//                return false;
//            }
//
//            // 3️⃣ Fetch Reservation & Guest
//            Reservation reservation = reservationDAO.getReservationById(reservationId);
//            if (reservation == null) {
//                System.out.println("Reservation not found!");
//                return false;
//            }
//
//            Guest guest = guestDAO.getGuestById(reservation.getGuestId());
//            if (guest == null) {
//                System.out.println("Guest not found!");
//                return false;
//            }
//
//            // 4️⃣ Generate PDF Invoice
//            String filePath = "invoices/invoice_" + reservation.getReservationNumber() + ".pdf";
//            PDFGenerator.generateInvoice(filePath, guest, reservation);
//
//
//
//            System.out.println("Payment successful & invoice generated at: " + filePath);
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public boolean makePayment(int reservationId, double amount, String method) {
        try {
            // 1️⃣ Create & Save Payment (Logic omitted for brevity)
            Payment payment = new Payment();
            // ... set properties
            boolean saved = paymentDAO.savePayment(payment);
            if (!saved) return false;

            // 2️⃣ Fetch Reservation & Guest
            Reservation reservation = reservationDAO.getReservationById(reservationId);
            Guest guest = (reservation != null) ? guestDAO.getGuestById(reservation.getGuestId()) : null;

            if (reservation == null || guest == null) {
                System.out.println("Data missing for PDF/Email generation!");
                return false;
            }

            // 3️⃣ Generate PDF Invoice
            String fileName = "invoice_" + reservation.getReservationNumber() + ".pdf";
            String filePath = "invoices/" + fileName;
            PDFGenerator.generateInvoice(filePath, guest, reservation);

            // 4️⃣ Send Email to Guest
            if (guest.getEmail() != null && !guest.getEmail().isEmpty()) {
                String subject = "Your Hotel Invoice - " + reservation.getReservationNumber();
                String message = "Dear " + guest.getFullName() + ",\n\n" +
                        "Thank you for booking with us. Please find attached your invoice for " +
                        amount + " " + method + ".\n\n" +
                        "Best regards,\nYour Hotel Team";

                boolean emailSent = EmailSender.sendEmailWithAttachment(
                        guest.getEmail(),
                        subject,
                        message,
                        filePath
                );

                if (emailSent) {
                    System.out.println("Invoice emailed successfully to: " + guest.getEmail());
                } else {
                    System.err.println("Note: Payment processed, but email failed to send.");
                }
            } else {
                System.out.println("No email address found for guest. Skipping email.");
            }

            System.out.println("Payment successful! Invoice: " + filePath);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}