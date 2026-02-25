package org.example.hotel.util;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;

import java.io.FileOutputStream;

public class PDFGenerator {

    public static void generateInvoice(String filePath, Guest guest, Reservation reservation) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Hotel Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Paragraph title = new Paragraph("Hotel Invoice", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new LineSeparator());

            // Guest Details
            Font subFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            document.add(new Paragraph("Guest Details", subFont));
            document.add(new Paragraph("Name: " + guest.getFullName()));
            document.add(new Paragraph("Address: " + guest.getAddress()));
            document.add(new Paragraph("Contact: " + guest.getContactNumber()));
            document.add(new Paragraph("Email: " + guest.getEmail()));
            document.add(new Paragraph(" "));

            // Reservation Details
            document.add(new Paragraph("Reservation Details", subFont));
            document.add(new Paragraph("Reservation Number: " + reservation.getReservationNumber()));
            document.add(new Paragraph("Room ID: " + reservation.getRoomId()));
            document.add(new Paragraph("Check-In: " + reservation.getCheckIn()));
            document.add(new Paragraph("Check-Out: " + reservation.getCheckOut()));
            document.add(new Paragraph("Total Amount: $" + reservation.getTotalAmount()));

            document.add(new Paragraph(" "));
            document.add(new LineSeparator());
            document.add(new Paragraph("Thank you for choosing our Hotel!", subFont));

            document.close();
            System.out.println("Invoice PDF generated at: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
