//package org.example.hotel.util;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.io.File;
//import java.util.Properties;
//
//public class EmailSender {
//
//    public static boolean sendEmailWithAttachment(
//            String toEmail,
//            String subject,
//            String messageBody,
//            String attachmentPath
//    ) {
//        final String fromEmail = "sritealecome@gmail.com";
//        final String appPassword = "kwer yvrc brqw geeb"; // Get from Google Account
//
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.smtp.socketFactory.port", "587");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
//        Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, appPassword);
//            }
//        });
//        session.setDebug(true); // Enable debug to see errors
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(fromEmail, "Hotel Name"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//            message.setSubject(subject);
//
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText(messageBody);
//
//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            File file = new File(attachmentPath);
//            if (!file.exists()) {
//                System.err.println("Attachment file not found: " + attachmentPath);
//                return false;
//            }
//            attachmentPart.attachFile(file);
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            multipart.addBodyPart(attachmentPart);
//
//            message.setContent(multipart);
//
//            Transport.send(message);
//            System.out.println("Email sent successfully to " + toEmail);
//            return true;
//
//        } catch (Exception e) {
//            System.err.println("Failed to send email: " + e.getMessage());
//            e.printStackTrace();
//            return false;
//        }
//    }
//}


package org.example.hotel.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class EmailSender {

    public static boolean sendEmailWithAttachment(
            String toEmail,
            String subject,
            String messageBody,
            String attachmentPath
    ) {
        final String fromEmail = "sritealecome@gmail.com";
        final String appPassword = "kwer yvrc brqw geeb";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, "Ocean View Resort"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            // Create container for text + possible attachment
            Multipart multipart = new MimeMultipart();

            // 1. Add Text Part
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(messageBody, "text/html; charset=utf-8");
            multipart.addBodyPart(textPart);

            // 2. Add Attachment Part (ONLY if file exists)
            if (attachmentPath != null && !attachmentPath.isEmpty()) {
                File file = new File(attachmentPath);
                if (file.exists()) {
                    MimeBodyPart attachmentPart = new MimeBodyPart();
                    attachmentPart.attachFile(file);
                    multipart.addBodyPart(attachmentPart);
                } else {
                    System.out.println("No attachment found at: " + attachmentPath + ". Sending text-only email.");
                }
            }

            message.setContent(multipart);
            Transport.send(message);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}