package org.example.hotel.dao;



import org.example.hotel.model.Payment;
import org.example.hotel.util.DBConnection;

import java.sql.*;

public class PaymentDAO {

    public boolean savePayment(Payment payment) {
        String sql = "INSERT INTO payments (reservation_id, payment_date, amount, method) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payment.getReservationId());
            ps.setTimestamp(2, Timestamp.valueOf(payment.getPaymentDate()));
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getMethod());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}