package org.example.hotel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hotel.dao.MessageDAO;
import org.example.hotel.model.Message;

import java.io.IOException;
import java.util.List;

// Map this servlet to all three staff roles!
@WebServlet(urlPatterns = {"/reception/messages", "/admin/messages", "/superadmin/messages"})
public class ViewMessagesServlet extends HttpServlet {

    private MessageDAO messageDAO = new MessageDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Message> messages = messageDAO.getAllMessages();
        request.setAttribute("messages", messages);

        // Forward to a shared JSP in the common folder
        request.getRequestDispatcher("/WEB-INF/common/viewMessages.jsp").forward(request, response);
    }
}