package org.example.hotel.dao;

import org.example.hotel.model.Payment;
import org.example.hotel.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {

    public boolean savePayment(Connection con, Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (reservation_id, payment_date, amount, method) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, payment.getReservationId());
            // Convert LocalDateTime to SQL Timestamp
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(payment.getPaymentDate()));
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getMethod());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean updatePaymentStatus(Connection con, int reservationId, String status) throws SQLException {
        // Updates a 'payment_status' column in your reservations table
        String sql = "UPDATE reservations SET payment_status = ? WHERE reservation_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, reservationId);
            return ps.executeUpdate() > 0;
        }
    }
}