package org.example.hotel.service;





import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class InvoiceService {

    private static final String INVOICE_PATH = "C:/hotel_invoices/"; // Change path as needed

    public String generateInvoice(Guest guest, Reservation reservation) {

        try {
            // Ensure directory exists
            File dir = new File(INVOICE_PATH);
            if (!dir.exists()) dir.mkdirs();

            String fileName = INVOICE_PATH + reservation.getReservationNumber() + ".pdf";
            PdfWriter writer = new PdfWriter(fileName);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Hotel Header
            document.add(new Paragraph("🏨 Hotel Invoice").setBold().setFontSize(20));
            document.add(new Paragraph("Reservation Number: " + reservation.getReservationNumber()));
            document.add(new Paragraph("Guest Name: " + guest.getFullName()));
            document.add(new Paragraph("Contact: " + guest.getContactNumber()));
            document.add(new Paragraph("Email: " + guest.getEmail()));
            document.add(new Paragraph("--------------------------------------------------"));

            // Reservation Details
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            document.add(new Paragraph("Room ID: " + reservation.getRoomId()));
            document.add(new Paragraph("Check-In: " + reservation.getCheckIn().format(df)));
            document.add(new Paragraph("Check-Out: " + reservation.getCheckOut().format(df)));
            document.add(new Paragraph("Total Amount: $" + reservation.getTotalAmount()));
            document.add(new Paragraph("--------------------------------------------------"));

            // Footer
            document.add(new Paragraph("Thank you for staying with us!").setItalic());

            document.close();
            return fileName;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}