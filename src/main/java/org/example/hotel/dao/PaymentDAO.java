package org.example.hotel.dao;

import org.example.hotel.model.Payment;
import org.example.hotel.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Payment> getAllPayments() {
        List<Payment> list = new ArrayList<>();
        // SQL JOIN to get the guest's name and reservation number alongside the payment
        String sql = "SELECT p.*, r.reservation_number, g.full_name " +
                "FROM payments p " +
                "JOIN reservations r ON p.reservation_id = r.reservation_id " +
                "JOIN guests g ON r.guest_id = g.guest_id " +
                "ORDER BY p.payment_date DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Payment pay = new Payment();
                pay.setPaymentId(rs.getInt("payment_id"));
                pay.setReservationId(rs.getInt("reservation_id"));
                pay.setPaymentDate(rs.getTimestamp("payment_date").toLocalDateTime());
                pay.setAmount(rs.getDouble("amount"));
                pay.setMethod(rs.getString("method"));

                // Set the extra fields we added to the model
                pay.setReservationNumber(rs.getString("reservation_number"));
                pay.setGuestName(rs.getString("full_name"));

                list.add(pay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}