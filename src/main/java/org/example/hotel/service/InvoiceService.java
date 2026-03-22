package org.example.hotel.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;

import java.io.File;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceService {

    private static final Logger logger = Logger.getLogger(InvoiceService.class.getName());
    private static final String INVOICE_PATH = "C:/hotel_invoices/";

    public String generateInvoice(Guest guest, Reservation reservation) {

        try {

            // 1️⃣ Ensure directory exists
            File dir = new File(INVOICE_PATH);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                if (!created) {
                    logger.warning("Invoice directory could not be created!");
                }
            }

            // 2️⃣ File name
            String fileName = INVOICE_PATH + reservation.getReservationNumber() + ".pdf";

            // 3️⃣ Create Document (iText 5 style)
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();

            // 4️⃣ Fonts
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font italicFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12);

            // 5️⃣ Header
            document.add(new Paragraph("HOTEL INVOICE", headerFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Reservation Number: " + reservation.getReservationNumber(), normalFont));
            document.add(new Paragraph("Guest Name: " + guest.getFullName(), normalFont));
            document.add(new Paragraph("Contact: " + guest.getContactNumber(), normalFont));
            document.add(new Paragraph("Email: " + guest.getEmail(), normalFont));
            document.add(new Paragraph("--------------------------------------------------"));

            // 6️⃣ Reservation Details
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            document.add(new Paragraph("Room ID: " + reservation.getRoomId(), normalFont));
            document.add(new Paragraph("Check-In: " + reservation.getCheckIn().format(df), normalFont));
            document.add(new Paragraph("Check-Out: " + reservation.getCheckOut().format(df), normalFont));
            document.add(new Paragraph("Total Amount: $" + reservation.getTotalAmount(), normalFont));
            document.add(new Paragraph("--------------------------------------------------"));

            // 7️⃣ Footer
            document.add(new Paragraph("Thank you for staying with us!", italicFont));

            document.close();

            logger.info("Invoice generated successfully: " + fileName);

            return fileName;

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error generating invoice", e);
            return null;
        }
    }
}