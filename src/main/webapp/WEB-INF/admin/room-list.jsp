<%@ page import="java.util.List" %>
<%@ page import="org.example.hotel.model.Room" %>

<table border="1" style="width:100%; border-collapse: collapse; text-align: left; font-family: sans-serif;">
    <thead style="background-color: #5a1212; color: white;">
    <tr>
        <th>Image</th>
        <th>Room Name</th>
        <th>Type</th>
        <th>Fare</th>
        <th>Capacity (A/C)</th>
        <th>Facilities</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Room> roomList = (List<Room>) request.getAttribute("rooms");
        if (roomList != null) {
            for (Room room : roomList) {
    %>
    <tr>
        <td style="width: 120px; padding: 5px;">
            <% if(room.getImagePath() != null) { %>
            <img src="<%= request.getContextPath() %>/<%= room.getImagePath() %>"
                 alt="Room" style="width: 100px; height: 70px; object-fit: cover; border-radius: 4px;">
            <% } else { %>
            <span style="color: #ccc;">No Image</span>
            <% } %>
        </td>
        <td><%= room.getRoomNumber() %></td>
        <td><%= room.getRoomType() %></td>
        <td>$<%= String.format("%.2f", room.getPricePerNight()) %></td>
        <td><%= room.getMaxAdults() %> Adults / <%= room.getMaxChildren() %> Children</td>
        <td style="font-size: 0.9em; color: #555;"><%= room.getAmenities() %></td>
        <td>
                <span style="padding: 2px 8px; border-radius: 10px; color: white; background-color: <%= room.getStatus().equals("AVAILABLE") ? "#28a745" : "#dc3545" %>;">
                    <%= room.getStatus() %>
                </span>
        </td>
        <td>
            <a href="editRoom?id=<%= room.getRoomId() %>" style="color: blue;">Edit</a> |
            <a href="deleteRoom?id=<%= room.getRoomId() %>" style="color: red;" onclick="return confirm('Delete this room?')">Delete</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="8" style="text-align:center; padding: 20px;">No rooms found.</td></tr>
    <% } %>
    </tbody>
</table>