package org.example.hotel.model;

import java.sql.Timestamp;

public class Message {
    private int messageId;
    private String name;
    private String email;
    private String subject;
    private String messageText;
    private Timestamp submittedAt;
    private String status;

    public Message() {}

    // Getters
    public int getMessageId() { return messageId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getSubject() { return subject; }
    public String getMessageText() { return messageText; }
    public Timestamp getSubmittedAt() { return submittedAt; }
    public String getStatus() { return status; }

    // Setters
    public void setMessageId(int messageId) { this.messageId = messageId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setMessageText(String messageText) { this.messageText = messageText; }
    public void setSubmittedAt(Timestamp submittedAt) { this.submittedAt = submittedAt; }
    public void setStatus(String status) { this.status = status; }
}