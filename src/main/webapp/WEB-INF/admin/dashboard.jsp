<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/24/2026
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Dashboard</h2>
<p>Total Rooms: <%= dashboard.getTotalRooms() %></p>
<p>Available Rooms: <%= dashboard.getAvailableRooms() %></p>
<p>Total Reservations: <%= dashboard.getTotalReservations() %></p>
