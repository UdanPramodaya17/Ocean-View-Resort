package org.example.hotel.dao;

import org.example.hotel.model.Payment;
import org.example.hotel.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class PaymentDAO {

    public boolean savePayment(Payment payment) {
        String sql = "INSERT INTO payments (reservation_id, amount, method, payment_date) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payment.getReservationId());
            ps.setDouble(2, payment.getAmount());
            ps.setString(3, payment.getMethod());
            // Converting LocalDateTime to SQL Timestamp
            ps.setTimestamp(4, Timestamp.valueOf(payment.getPaymentDate()));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}