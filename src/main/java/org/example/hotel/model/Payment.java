package org.example.hotel.model;



import java.time.LocalDateTime;

public class Payment {

    private int paymentId;
    private int reservationId;
    private LocalDateTime paymentDate;
    private double amount;
    private String method;

    public Payment() {}

    public Payment(int paymentId, int reservationId,
                   LocalDateTime paymentDate,
                   double amount, String method) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.method = method;
    }

    // Getters
    public int getPaymentId() {
        return paymentId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    // Setters
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
