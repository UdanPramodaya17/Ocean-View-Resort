<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<div style="max-width: 1000px; margin: 40px auto; font-family: sans-serif;">
  <h2 style="color: #333; border-bottom: 2px solid #ccc; padding-bottom: 10px; margin-bottom: 20px;">
    Inbox / Contact Messages
  </h2>

  <table style="width: 100%; border-collapse: collapse; box-shadow: 0 4px 8px rgba(0,0,0,0.1); background: #fff;">
    <thead style="background-color: #1E3C72; color: white;">
    <tr>
      <th style="padding: 12px; text-align: left;">Date</th>
      <th style="padding: 12px; text-align: left;">Name</th>
      <th style="padding: 12px; text-align: left;">Email</th>
      <th style="padding: 12px; text-align: left;">Subject</th>
      <th style="padding: 12px; text-align: left; width: 35%;">Message</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${not empty messages}">
        <c:forEach var="msg" items="${messages}">
          <tr style="border-bottom: 1px solid #eee;">
            <td style="padding: 12px; font-size: 14px; color: #666;">
                ${msg.submittedAt}
            </td>
            <td style="padding: 12px; font-weight: bold; color: #333;">${msg.name}</td>
            <td style="padding: 12px;">
              <a href="mailto:${msg.email}" style="color: #3498db; text-decoration: none;">${msg.email}</a>
            </td>
            <td style="padding: 12px; font-weight: bold; color: #444;">${msg.subject}</td>
            <td style="padding: 12px; font-size: 14px; color: #555; line-height: 1.4;">
                ${msg.messageText}
            </td>
          </tr>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <tr>
          <td colspan="5" style="text-align: center; padding: 30px; color: #888;">
            No messages found. Your inbox is empty!
          </td>
        </tr>
      </c:otherwise>
    </c:choose>
    </tbody>
  </table>
</div>

<%@ include file="footer.jsp" %>