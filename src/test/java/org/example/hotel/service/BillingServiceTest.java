package org.example.hotel.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BillingService Tests")
class BillingServiceTest {

    private BillingService billingService;

    @BeforeEach
    void setUp() {
        billingService = new BillingService();
    }

    @Test
    @DisplayName("Should calculate bill correctly for standard stay")
    void testCalculateBillStandardStay() {
        LocalDate checkIn = LocalDate.of(2026, 3, 7);
        LocalDate checkOut = LocalDate.of(2026, 3, 10);
        double pricePerNight = 100.0;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        assertEquals(300.0, bill, "Bill should be 3 nights * 100 = 300");
    }

    @Test
    @DisplayName("Should calculate bill for single night stay")
    void testCalculateBillSingleNight() {
        LocalDate checkIn = LocalDate.of(2026, 3, 7);
        LocalDate checkOut = LocalDate.of(2026, 3, 8);
        double pricePerNight = 150.0;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        assertEquals(150.0, bill, "Bill should be 1 night * 150 = 150");
    }

    @Test
    @DisplayName("Should calculate bill for extended stay")
    void testCalculateBillExtendedStay() {
        LocalDate checkIn = LocalDate.of(2026, 3, 1);
        LocalDate checkOut = LocalDate.of(2026, 3, 15);
        double pricePerNight = 120.0;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        assertEquals(1680.0, bill, "Bill should be 14 nights * 120 = 1680");
    }

    @Test
    @DisplayName("Should calculate bill with decimal price per night")
    void testCalculateBillDecimalPrice() {
        LocalDate checkIn = LocalDate.of(2026, 3, 7);
        LocalDate checkOut = LocalDate.of(2026, 3, 12);
        double pricePerNight = 99.99;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        double expected = 5 * 99.99;
        assertEquals(expected, bill, 0.01, "Bill should be 5 nights * 99.99");
    }

    @Test
    @DisplayName("Should calculate bill with high price per night")
    void testCalculateBillHighPrice() {
        LocalDate checkIn = LocalDate.of(2026, 3, 7);
        LocalDate checkOut = LocalDate.of(2026, 3, 14);
        double pricePerNight = 500.0;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        assertEquals(3500.0, bill, "Bill should be 7 nights * 500 = 3500");
    }

    @Test
    @DisplayName("Should calculate bill for zero nights (same check-in and check-out)")
    void testCalculateBillZeroNights() {
        LocalDate checkIn = LocalDate.of(2026, 3, 7);
        LocalDate checkOut = LocalDate.of(2026, 3, 7);
        double pricePerNight = 100.0;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        assertEquals(0.0, bill, "Bill should be 0 for same day check-in and check-out");
    }

    @Test
    @DisplayName("Should calculate bill with zero price per night")
    void testCalculateBillZeroPrice() {
        LocalDate checkIn = LocalDate.of(2026, 3, 7);
        LocalDate checkOut = LocalDate.of(2026, 3, 10);
        double pricePerNight = 0.0;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        assertEquals(0.0, bill, "Bill should be 0 when price per night is 0");
    }

    @Test
    @DisplayName("Should calculate bill with negative price (refund scenario)")
    void testCalculateBillNegativePrice() {
        LocalDate checkIn = LocalDate.of(2026, 3, 7);
        LocalDate checkOut = LocalDate.of(2026, 3, 10);
        double pricePerNight = -50.0;
        
        double bill = billingService.calculateBill(checkIn, checkOut, pricePerNight);
        
        assertEquals(-150.0, bill, "Bill should be negative for refund scenario");
    }
}
