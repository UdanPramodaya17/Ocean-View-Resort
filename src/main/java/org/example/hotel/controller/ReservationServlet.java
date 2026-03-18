////package org.example.hotel.controller;
////
////
////
////
////import jakarta.servlet.*;
////import jakarta.servlet.http.*;
////import org.example.hotel.model.Guest;
////import org.example.hotel.service.ReservationService;
////import org.example.hotel.model.Room;
////import org.example.hotel.dao.RoomDAO;
////
////import java.io.IOException;
////import java.time.LocalDate;
////
////public class ReservationServlet extends HttpServlet {
////
////    protected void doPost(HttpServletRequest request,
////                          HttpServletResponse response)
////            throws ServletException, IOException {
////
////        Guest guest = new Guest();
////        guest.setFullName(request.getParameter("fullName"));
////        guest.setAddress(request.getParameter("address"));
////        guest.setContactNumber(request.getParameter("contact"));
////        guest.setEmail(request.getParameter("email"));
////
////        int roomId = Integer.parseInt(request.getParameter("roomId"));
////
////        // Get room type from room ID
////        RoomDAO roomDAO = new RoomDAO();
////        Room room = roomDAO.getAllRooms().stream()
////                .filter(r -> r.getRoomId() == roomId)
////                .findFirst()
////                .orElse(null);
////
////        if (room == null) {
////            request.setAttribute("error", "Invalid room ID!");
////            request.getRequestDispatcher("jsp/reception/book-reservation.jsp")
////                    .forward(request, response);
////            return;
////        }
////
////        String roomType = room.getRoomType();
////        LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
////        LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));
////        double price = Double.parseDouble(request.getParameter("price"));
////
////        ReservationService service = new ReservationService();
////
////        boolean success = service.createReservation(
////                guest, roomType, checkIn, checkOut, price);
////
////        if (success) {
////            response.sendRedirect("jsp/reception/dashboard.jsp?success=1");
////        } else {
////            request.setAttribute("error",
////                    "Room already booked for selected dates!");
////            request.getRequestDispatcher(
////                    "jsp/reception/book-reservation.jsp"
////            ).forward(request, response);
////        }
////    }
////}
//
//
//
//
////
////package org.example.hotel.controller;
////
////import jakarta.servlet.*;
////import jakarta.servlet.http.*;
////import jakarta.servlet.annotation.WebServlet;
////
////import org.example.hotel.model.Guest;
////import org.example.hotel.model.Room;
////import org.example.hotel.service.ReservationService;
////import org.example.hotel.dao.RoomDAO;
////
////import java.io.IOException;
////import java.time.LocalDate;
////import java.time.temporal.ChronoUnit;
////
////@WebServlet("/reception/book")
////public class ReservationServlet extends HttpServlet {
////
////    @Override
////    protected void doPost(HttpServletRequest request,
////                          HttpServletResponse response)
////            throws ServletException, IOException {
////
////        try {
////
////            // 1️⃣ Collect Guest
////            Guest guest = new Guest();
////            guest.setFullName(request.getParameter("fullName"));
////            guest.setAddress(request.getParameter("address"));
////            guest.setContactNumber(request.getParameter("contact"));
////            guest.setEmail(request.getParameter("email"));
////
////            // 2️⃣ Room ID
////            int roomId = Integer.parseInt(request.getParameter("roomId"));
////
////            RoomDAO roomDAO = new RoomDAO();
////            Room room = roomDAO.getRoomById(roomId);
////
////            if (room == null) {
////                request.setAttribute("error", "Invalid room selected!");
////                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
////                        .forward(request, response);
////                return;
////            }
////
////            // 3️⃣ Dates
////            LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
////            LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));
////
////            if (checkOut.isBefore(checkIn) || checkOut.isEqual(checkIn)) {
////                request.setAttribute("error", "Invalid date range!");
////                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
////                        .forward(request, response);
////                return;
////            }
////
////            // 4️⃣ Price from DB (NOT from form)
////            double pricePerNight = room.getPricePerNight();
////
////            // 5️⃣ Create Reservation
////            ReservationService service = new ReservationService();
////
////            boolean success = service.createReservation(
////                    guest,
////                    room.getRoomType(),
////                    checkIn,
////                    checkOut,
////                    pricePerNight
////            );
////
////            if (success) {
////                response.sendRedirect(request.getContextPath() +
////                        "/WEB-INF/reception/dashboard.jsp?success=1");
////            } else {
////                request.setAttribute("error",
////                        "Room already booked for selected dates!");
////                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
////                        .forward(request, response);
////            }
////
////        } catch (Exception e) {
////            request.setAttribute("error", "Something went wrong!");
////            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp")
////                    .forward(request, response);
////        }
////    }
////}
//
//package org.example.hotel.controller;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.WebServlet;
//
//import org.example.hotel.model.Guest;
//import org.example.hotel.model.Room;
//import org.example.hotel.service.ReservationService;
//import org.example.hotel.dao.RoomDAO;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//
//@WebServlet("/reception/book")
//public class ReservationServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
////        try {
////            // 1️⃣ Collect Guest Data
////            Guest guest = new Guest();
////            guest.setFullName(request.getParameter("fullName"));
////            guest.setAddress(request.getParameter("address"));
////            guest.setContactNumber(request.getParameter("contact"));
////            guest.setEmail(request.getParameter("email"));
////
////            // 2️⃣ Get Room Type from JSP (Matched to <select name="roomType">)
////            String roomType = request.getParameter("roomType");
////
////            if (roomType == null || roomType.isEmpty()) {
////                throw new Exception("Room type selection is required.");
////            }
////
////// 3️⃣ Skip fetching Room by ID here, let the Service handle it
////// 4️⃣ Dates
////            LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
////            LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));
////
////// 5️⃣ Create Reservation
////            ReservationService service = new ReservationService();
////
////// Pass 0.0 for price because the Service will fetch the correct price from DB
////            boolean success = service.createReservation(
////                    guest,
////                    roomType,
////                    checkIn,
////                    checkOut,
////                    0.0
////            );
////            if (success) {
////                // ✅ FIXED: Redirect to a URL, not a WEB-INF path.
////                // Assumes you have a Servlet mapped to /reception/dashboard
////                response.sendRedirect(request.getContextPath() + "/reception/dashboard?success=1");
////            } else {
////                request.setAttribute("error", "Room is already booked for these dates!");
////                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
////            }
////
////        } catch (Exception e) {
////            e.printStackTrace(); // Log the error to console for debugging
////            request.setAttribute("error", "Error: " + e.getMessage());
////            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
////        }
////    }
//
//        try {
//            // 1. Capture Guest details from the form
//            String fullName = request.getParameter("fullName");
//            String contact = request.getParameter("contact");
//            String email = request.getParameter("email");
//
//            // 2. Combine the Address details from the 3 separate fields
//            String addressLine = request.getParameter("address");
//            String city = request.getParameter("city");
//            String province = request.getParameter("province");
//
//            String fullAddress = addressLine;
//            if (city != null && !city.trim().isEmpty()) {
//                fullAddress += ", " + city;
//            }
//            if (province != null && !province.trim().isEmpty()) {
//                fullAddress += ", " + province;
//            }
//
//            // 3. Capture Booking details
//            String roomType = request.getParameter("roomType");
//            String checkInStr = request.getParameter("checkIn");
//            String checkOutStr = request.getParameter("checkOut");
//
//            // Basic Validation
//            if (roomType == null || roomType.trim().isEmpty() || roomType.equals("Please select a room")) {
//                request.setAttribute("error", "Invalid Room Type. Please select a room from the Available Rooms page.");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//                return;
//            }
//
//            // Parse Dates
//            LocalDate checkIn = LocalDate.parse(checkInStr);
//            LocalDate checkOut = LocalDate.parse(checkOutStr);
//
//            if (!checkOut.isAfter(checkIn)) {
//                request.setAttribute("error", "Check-out date must be after Check-in date.");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//                return;
//            }
//
//            // 4. Create the Guest Object
//            Guest guest = new Guest();
//            guest.setFullName(fullName);
//            guest.setContactNumber(contact);
//            guest.setEmail(email);
//            guest.setAddress(fullAddress); // Saving the combined address!
//
//            // 5. Call the Service to save everything
//            ReservationService service = new ReservationService();
//
//            // Note: The service calculates the actual price internally based on the room it finds.
//            // We pass 0.0 here because your latest ReservationService ignores this parameter anyway.
//            boolean success = service.createReservation(guest, roomType, checkIn, checkOut, 0.0);
//
//            if (success) {
//                // Redirect to the dashboard with a success message
//                response.sendRedirect(request.getContextPath() + "/reception/dashboard?msg=BookingSuccessful");
//            } else {
//                request.setAttribute("error", "Failed to create reservation. No " + roomType + " rooms might be available for these dates.");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//            }
//
//        } catch (DateTimeParseException e) {
//            request.setAttribute("error", "Invalid date format selected.");
//            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("error", "An unexpected system error occurred: " + e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//        }
//    }
//
//}


















//package org.example.hotel.controller;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.WebServlet;
//
//import org.example.hotel.model.Guest;
//import org.example.hotel.service.ReservationService;
//import org.example.hotel.util.EmailSender;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//
//@WebServlet("/reception/book")
//public class ReservationServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            // 1. Capture Guest details from the form
//            String fullName = request.getParameter("fullName");
//            String contact = request.getParameter("contact");
//            String email = request.getParameter("email");
//
//            // 2. Combine the Address details
//            String addressLine = request.getParameter("address");
//            String city = request.getParameter("city");
//            String province = request.getParameter("province");
//
//            StringBuilder fullAddressBuilder = new StringBuilder(addressLine);
//            if (city != null && !city.trim().isEmpty()) {
//                fullAddressBuilder.append(", ").append(city);
//            }
//            if (province != null && !province.trim().isEmpty()) {
//                fullAddressBuilder.append(", ").append(province);
//            }
//            String fullAddress = fullAddressBuilder.toString();
//
//            // 3. Capture Booking details
//            String roomType = request.getParameter("roomType");
//            String checkInStr = request.getParameter("checkIn");
//            String checkOutStr = request.getParameter("checkOut");
//
//            // Basic Validation
//            if (roomType == null || roomType.trim().isEmpty() || roomType.equals("Please select a room")) {
//                request.setAttribute("error", "Invalid Room Type. Please select a room.");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//                return;
//            }
//
//            // Parse Dates
//            LocalDate checkIn = LocalDate.parse(checkInStr);
//            LocalDate checkOut = LocalDate.parse(checkOutStr);
//
//            if (!checkOut.isAfter(checkIn)) {
//                request.setAttribute("error", "Check-out date must be after Check-in date.");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//                return;
//            }
//
//            // 4. Create the Guest Object
//            Guest guest = new Guest();
//            guest.setFullName(fullName);
//            guest.setContactNumber(contact);
//            guest.setEmail(email);
//            guest.setAddress(fullAddress);
//
//            // 5. Call Service to save reservation
//            ReservationService service = new ReservationService();
//            boolean success = service.createReservation(guest, roomType, checkIn, checkOut, 0.0);
//
//            if (success) {
//                // 6. Trigger Email Sending in a Background Thread
//                sendConfirmationEmail(email, fullName, roomType, checkInStr, checkOutStr);
//
//                // 7. Redirect to dashboard
//                response.sendRedirect(request.getContextPath() + "/reception/dashboard?msg=BookingSuccessful");
//            } else {
//                request.setAttribute("error", "Failed to create reservation. Room might not be available.");
//                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//            }
//
//        } catch (DateTimeParseException e) {
//            request.setAttribute("error", "Invalid date format selected.");
//            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("error", "System error: " + e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
//        }
//    }
//
//    /**
//     * Helper method to handle email logic without blocking the main UI thread.
//     */
//    private void sendConfirmationEmail(String toEmail, String name, String type, String in, String out) {
//        new Thread(() -> {
//            String subject = "Booking Confirmation - Your Stay is Confirmed!";
//            String body = "Dear " + name + ",\n\n" +
//                    "Thank you for your booking. We are pleased to confirm your reservation.\n\n" +
//                    "Details:\n" +
//                    "- Room Type: " + type + "\n" +
//                    "- Check-in: " + in + "\n" +
//                    "- Check-out: " + out + "\n\n" +
//                    "We look forward to seeing you!";
//
//            // Note: If you don't have a real PDF file yet, the EmailSender
//            // as written in your snippet will return 'false' and print an error.
//            // Ensure a file exists at this path or modify EmailSender to handle nulls.
//            String placeholderPath = getServletContext().getRealPath("/WEB-INF/resources/hotel-policy.pdf");
//
//            EmailSender.sendEmailWithAttachment(toEmail, subject, body, placeholderPath);
//        }).start();
//    }
//}






package org.example.hotel.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.example.hotel.model.Guest;
import org.example.hotel.service.ReservationService;
import org.example.hotel.util.EmailSender;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/reception/book")
public class ReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 1. Capture Guest details
            String fullName = request.getParameter("fullName");
            String contact = request.getParameter("contact");
            String email = request.getParameter("email");

            // 2. Combine Address fields
            String addressLine = request.getParameter("address");
            String city = request.getParameter("city");
            String province = request.getParameter("province");

            String fullAddress = addressLine + (city != null ? ", " + city : "") + (province != null ? ", " + province : "");

            // 3. Capture & Validate Booking details
            String roomType = request.getParameter("roomType");
            String checkInStr = request.getParameter("checkIn");
            String checkOutStr = request.getParameter("checkOut");

            if (roomType == null || roomType.isEmpty() || roomType.equals("Please select a room")) {
                request.setAttribute("error", "Please select a valid room type.");
                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
                return;
            }

            LocalDate checkIn = LocalDate.parse(checkInStr);
            LocalDate checkOut = LocalDate.parse(checkOutStr);

            if (!checkOut.isAfter(checkIn)) {
                request.setAttribute("error", "Check-out date must be after Check-in.");
                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
                return;
            }

            // 4. Create the Guest Object
            Guest guest = new Guest();
            guest.setFullName(fullName);
            guest.setContactNumber(contact);
            guest.setEmail(email);
            guest.setAddress(fullAddress);

            // 5. Call Service to save reservation
            ReservationService service = new ReservationService();
            // Passing 0.0 as price is often handled inside the service logic
            boolean success = service.createReservation(guest, roomType, checkIn, checkOut, 0.0);

            if (success) {
                // 6. Trigger Email in Background Thread
                // We pass 'null' for the attachment path if the PDF isn't generated yet
                // to avoid the "File Not Found" error you experienced.
                sendConfirmationEmail(email, fullName, roomType, checkInStr, checkOutStr, null);

                response.sendRedirect(request.getContextPath() + "/reception/dashboard?msg=BookingSuccessful");
            } else {
                request.setAttribute("error", "Booking failed. No available rooms for selected type.");
                request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
            }

        } catch (DateTimeParseException e) {
            request.setAttribute("error", "Invalid date format.");
            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "System Error: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/reception/book-reservation.jsp").forward(request, response);
        }
    }

    private void sendConfirmationEmail(String toEmail, String name, String type, String in, String out, String pdfPath) {
        new Thread(() -> {
            String subject = "🏨 Booking Confirmed - " + type;

            // Beautiful HTML Body
            String htmlBody = "<html><body style='font-family: Arial, sans-serif; color: #333; line-height: 1.6;'>" +
                    "<div style='max-width: 600px; margin: auto; border: 1px solid #eee; padding: 20px; border-radius: 10px;'>" +
                    "  <h2 style='color: #5a1212; text-align: center;'>Reservation Confirmed!</h2>" +
                    "  <p>Dear <strong>" + name + "</strong>,</p>" +
                    "  <p>We are delighted to inform you that your booking has been received and confirmed. We look forward to welcoming you!</p>" +
                    "  <div style='background: #f9f9f9; padding: 15px; border-radius: 5px; margin: 20px 0;'>" +
                    "    <h4 style='margin-top: 0; border-bottom: 1px solid #ddd;'>Booking Details</h4>" +
                    "    <table style='width: 100%;'>" +
                    "      <tr><td><strong>Room Type:</strong></td><td>" + type + "</td></tr>" +
                    "      <tr><td><strong>Check-in:</strong></td><td>" + in + "</td></tr>" +
                    "      <tr><td><strong>Check-out:</strong></td><td>" + out + "</td></tr>" +
                    "    </table>" +
                    "  </div>" +
                    "  <p style='font-size: 12px; color: #777;'>If you have any questions, please reply to this email or call our support line.</p>" +
                    "  <p style='text-align: center; color: #5a1212;'><strong>The Hotel Management Team</strong></p>" +
                    "</div>" +
                    "</body></html>";

            EmailSender.sendEmailWithAttachment(toEmail, subject, htmlBody, pdfPath);
        }).start();
    }
}