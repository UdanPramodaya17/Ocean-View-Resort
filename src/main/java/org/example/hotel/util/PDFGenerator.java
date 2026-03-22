package org.example.hotel.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.example.hotel.model.Guest;
import org.example.hotel.model.Reservation;

import java.io.FileOutputStream;
import java.io.File;

public class PDFGenerator {

    public static void generateInvoice(String filePath, Guest guest, Reservation reservation) {
        // Create Document with standard margins
        Document document = new Document(PageSize.A4, 40, 40, 50, 50);

        try {
            // Ensure the directory exists
            File file = new File(filePath);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // --- Styling Colors ---
            BaseColor primaryColor = new BaseColor(90, 18, 18); // Elegant Deep Red (#5a1212)
            BaseColor secondaryColor = new BaseColor(245, 245, 245); // Light Gray for rows

            // --- Font Definitions ---
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, primaryColor);
            Font subTitleFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.DARK_GRAY);
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
            Font textFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
            Font boldText = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);

            // --- Header Section ---
            Paragraph hotelName = new Paragraph("OCEAN VIEW RESORT", titleFont);
            hotelName.setAlignment(Element.ALIGN_RIGHT);
            document.add(hotelName);

            Paragraph address = new Paragraph("123 Luxury Lane, Galle, Sri Lanka\nContact: +94 112 345 678", textFont);
            address.setAlignment(Element.ALIGN_RIGHT);
            document.add(address);

            document.add(new Paragraph("\n"));
            document.add(new LineSeparator(1f, 100, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER, -2));
            document.add(new Paragraph("\n"));

            // --- Info Grid Table (2 Columns) ---
            PdfPTable infoTable = new PdfPTable(2);
            infoTable.setWidthPercentage(100);

            // Left Side: Guest Info
            PdfPCell gCell = new PdfPCell();
            gCell.setBorder(Rectangle.NO_BORDER);
            gCell.addElement(new Phrase("BILL TO:", subTitleFont));
            gCell.addElement(new Paragraph(guest.getFullName(), boldText));
            gCell.addElement(new Paragraph(guest.getAddress(), textFont));
            gCell.addElement(new Paragraph("Email: " + guest.getEmail(), textFont));
            infoTable.addCell(gCell);

            // Right Side: Booking Info
            PdfPCell bCell = new PdfPCell();
            bCell.setBorder(Rectangle.NO_BORDER);
            bCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            bCell.addElement(new Phrase("INVOICE DETAILS:", subTitleFont));
            bCell.addElement(new Paragraph("Invoice No: " + reservation.getReservationNumber(), textFont));
            bCell.addElement(new Paragraph("Check-In: " + reservation.getCheckIn(), textFont));
            bCell.addElement(new Paragraph("Check-Out: " + reservation.getCheckOut(), textFont));
            infoTable.addCell(bCell);

            document.add(infoTable);
            document.add(new Paragraph("\n\n"));

            // --- Pricing Table ---
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{3.5f, 1.5f, 1.5f});

            // Headers
            String[] headers = {"Description", "Room Type", "Total"};
            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
                cell.setBackgroundColor(primaryColor);
                cell.setPadding(10);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Body Row
            table.addCell(createCell("Luxury Accommodation Services", textFont, secondaryColor, Element.ALIGN_LEFT));
            table.addCell(createCell("Room ID: " + reservation.getRoomId(), textFont, secondaryColor, Element.ALIGN_CENTER));

            // ✅ FIX: Formatted to 2 decimal places
            String formattedPrice = String.format("Rs. %.2f", reservation.getTotalAmount());
            table.addCell(createCell(formattedPrice, boldText, secondaryColor, Element.ALIGN_RIGHT));

            document.add(table);

            // --- Grand Total Section ---
            document.add(new Paragraph("\n"));
            Paragraph total = new Paragraph("GRAND TOTAL: " + formattedPrice, titleFont);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            // --- Footer ---
            Paragraph footer = new Paragraph("\n\n\nThank you for choosing The Royal Hotel.\nWe hope to see you again soon!",
                    new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC, BaseColor.GRAY));
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper Method to create styled cells
    private static PdfPCell createCell(String text, Font font, BaseColor bgColor, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(12);
        cell.setBackgroundColor(bgColor);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setBorderColor(BaseColor.WHITE);
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }
}