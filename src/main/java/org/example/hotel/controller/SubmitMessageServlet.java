package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.MessageDAO;
import org.example.hotel.model.Message;

import java.io.IOException;

@WebServlet("/submit-message")
public class SubmitMessageServlet extends HttpServlet {

    private MessageDAO messageDAO = new MessageDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Message msg = new Message();
        msg.setName(request.getParameter("name"));
        msg.setEmail(request.getParameter("email"));
        msg.setSubject(request.getParameter("subject"));
        msg.setMessageText(request.getParameter("message"));

        boolean success = messageDAO.saveMessage(msg);

        if (success) {
            // Send back a success message.
            // (You can change "/help" to whatever page your form is on)
            response.sendRedirect(request.getHeader("Referer") + "?success=MessageSent");
        } else {
            response.getWriter().println("Error sending message. Please try again.");
        }
    }
}