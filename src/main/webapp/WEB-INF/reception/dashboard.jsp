<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/24/2026
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Loop reservations --%>
<form action="${pageContext.request.contextPath}/checkinout" method="post">
    <input type="hidden" name="reservationId" value="<%= r.getReservationId() %>"/>
    <input type="hidden" name="roomId" value="<%= r.getRoomId() %>"/>
    <% if("BOOKED".equals(r.getStatus())){ %>
    <button name="action" value="checkin">Check-In</button>
    <% } else if("CHECKED_IN".equals(r.getStatus())){ %>
    <button name="action" value="checkout">Check-Out</button>
    <% } %>
</form>
</body>
</html>
