package org.example.hotel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BillingService {

    public double calculateBill(LocalDate checkIn,
                                LocalDate checkOut,
                                double pricePerNight) {

        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

        return nights * pricePerNight;
    }
}