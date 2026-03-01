<%@ page import="org.example.hotel.model.Room" %>
<%@ page import="java.util.List" %>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Number</th>
        <th>Type</th>
        <th>Price</th>
        <th>Status</th>
        <th>Quantity</th> <!-- NEW -->
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
        <td><%= r.getQuantity() %></td> <!-- NEW -->
        <td><img src="<%=request.getContextPath()%>/<%=r.getImagePath()%>" width="100"/></td>
    </tr>
    <% } %>
</table>