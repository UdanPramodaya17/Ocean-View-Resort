<%@ page import="org.example.hotel.model.Room" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/25/2026
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<h2>Room List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Number</th>
        <th>Type</th>
        <th>Price</th>
        <th>Status</th>
        <th>Image</th>
    </tr>

    <%
        List<Room> rooms = (List<Room>) request.getAttribute("rooms");
        for(Room r : rooms){
    %>
    <tr>
        <td><%= r.getRoomId() %></td>
        <td><%= r.getRoomNumber() %></td>
        <td><%= r.getRoomType() %></td>
        <td><%= r.getPricePerNight() %></td>
        <td><%= r.getStatus() %></td>
        <td><img src="<%=request.getContextPath()%>/<%=r.getImagePath()%>" width="100"/></td>
    </tr>
    <% } %>
</table>
</html>
