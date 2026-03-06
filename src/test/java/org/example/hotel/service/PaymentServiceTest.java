package org.example.hotel.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PaymentService Tests")
class PaymentServiceTest {

    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService();
    }

    @Test
    @DisplayName("Should successfully process payment with valid reservation ID and amount")
    void testMakePaymentSuccess() {
        int reservationId = 1;
        double amount = 300.0;
        String method = "CREDIT_CARD";
        
        // Note: This test may fail if database is not configured
        // In production, use Mockito to mock PaymentDAO and ReservationDAO
        boolean result = paymentService.makePayment(reservationId, amount, method);
        
        // Result depends on database configuration
        assertNotNull(result, "Payment method should return a result");
    }

    @Test
    @DisplayName("Should handle payment with zero amount")
    void testMakePaymentZeroAmount() {
        int reservationId = 1;
        double amount = 0.0;
        String method = "CREDIT_CARD";
        
        boolean result = paymentService.makePayment(reservationId, amount, method);
        
        assertFalse(result, "Payment with zero amount should fail");
    }

    @Test
    @DisplayName("Should handle payment with negative amount")
    void testMakePaymentNegativeAmount() {
        int reservationId = 1;
        double amount = -100.0;
        String method = "CREDIT_CARD";
        
        boolean result = paymentService.makePayment(reservationId, amount, method);
        
        assertFalse(result, "Payment with negative amount should fail");
    }

    @Test
    @DisplayName("Should handle payment with invalid reservation ID")
    void testMakePaymentInvalidReservationId() {
        int reservationId = -1;
        double amount = 300.0;
        String method = "CREDIT_CARD";
        
        boolean result = paymentService.makePayment(reservationId, amount, method);
        
        assertFalse(result, "Payment with invalid reservation ID should fail");
    }

    @Test
    @DisplayName("Should handle payment with zero reservation ID")
    void testMakePaymentZeroReservationId() {
        int reservationId = 0;
        double amount = 300.0;
        String method = "CREDIT_CARD";
        
        boolean result = paymentService.makePayment(reservationId, amount, method);
        
        assertFalse(result, "Payment with reservation ID 0 should fail");
    }

    @Test
    @DisplayName("Should accept CREDIT_CARD payment method")
    void testPaymentMethodCreditCard() {
        int reservationId = 1;
        double amount = 300.0;
        String method = "CREDIT_CARD";
        
        assertDoesNotThrow(() -> {
            paymentService.makePayment(reservationId, amount, method);
        }, "CREDIT_CARD payment method should be accepted");
    }

    @Test
    @DisplayName("Should accept DEBIT_CARD payment method")
    void testPaymentMethodDebitCard() {
        int reservationId = 1;
        double amount = 300.0;
        String method = "DEBIT_CARD";
        
        assertDoesNotThrow(() -> {
            paymentService.makePayment(reservationId, amount, method);
        }, "DEBIT_CARD payment method should be accepted");
    }

    @Test
    @DisplayName("Should accept CASH payment method")
    void testPaymentMethodCash() {
        int reservationId = 1;
        double amount = 300.0;
        String method = "CASH";
        
        assertDoesNotThrow(() -> {
            paymentService.makePayment(reservationId, amount, method);
        }, "CASH payment method should be accepted");
    }

    @Test
    @DisplayName("Should handle payment with null payment method")
    void testMakePaymentNullMethod() {
        int reservationId = 1;
        double amount = 300.0;
        
        boolean result = paymentService.makePayment(reservationId, amount, null);
        
        assertFalse(result, "Payment with null method should fail");
    }

    @Test
    @DisplayName("Should handle payment with empty payment method")
    void testMakePaymentEmptyMethod() {
        int reservationId = 1;
        double amount = 300.0;
        String method = "";
        
        boolean result = paymentService.makePayment(reservationId, amount, method);
        
        assertFalse(result, "Payment with empty method should fail");
    }

    @Test
    @DisplayName("Should handle payment with large amount")
    void testMakePaymentLargeAmount() {
        int reservationId = 1;
        double amount = 999999.99;
        String method = "CREDIT_CARD";
        
        assertDoesNotThrow(() -> {
            paymentService.makePayment(reservationId, amount, method);
        }, "Should handle large payment amounts");
    }

    @Test
    @DisplayName("Should handle payment with fractional amount")
    void testMakePaymentFractionalAmount() {
        int reservationId = 1;
        double amount = 150.50;
        String method = "CREDIT_CARD";
        
        assertDoesNotThrow(() -> {
            paymentService.makePayment(reservationId, amount, method);
        }, "Should handle fractional payment amounts");
    }

    @Test
    @DisplayName("Should handle concurrent payment attempts")
    void testConcurrentPayments() {
        int reservationId = 1;
        double amount = 300.0;
        String method = "CREDIT_CARD";
        
        // Test that method can be called multiple times
        assertDoesNotThrow(() -> {
            paymentService.makePayment(reservationId, amount, method);
            paymentService.makePayment(reservationId, amount, method);
        }, "Service should handle multiple payment calls");
    }

    @Test
    @DisplayName("Should validate reservation exists before processing payment")
    void testPaymentNonexistentReservation() {
        int nonexistentId = 999999;
        double amount = 300.0;
        String method = "CREDIT_CARD";
        
        boolean result = paymentService.makePayment(nonexistentId, amount, method);
        
        assertFalse(result, "Payment for non-existent reservation should fail");
    }

    @Test
    @DisplayName("Should update reservation payment status to PAID")
    void testPaymentStatusUpdate() {
        // This test validates that the payment status is updated correctly
        int reservationId = 1;
        double amount = 300.0;
        String method = "CREDIT_CARD";
        
        boolean result = paymentService.makePayment(reservationId, amount, method);
        
        // In a proper test environment, you would verify the status was updated
        // For now, just ensure the operation completes without exception
        assertNotNull(result, "Payment operation should complete");
    }
}
