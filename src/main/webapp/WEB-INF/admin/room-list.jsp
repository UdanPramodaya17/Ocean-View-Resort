<%@ page import="java.util.List" %>
<%@ page import="org.example.hotel.model.Room" %>
<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; font-family: sans-serif;">
    <h2 style="color: #333; margin: 0;">Room Management</h2>

    <a href="<%= request.getContextPath() %>/admin/dashboard"
       style="text-decoration: none; background-color: #6c757d; color: white; padding: 10px 20px; border-radius: 4px; font-size: 14px; font-weight: bold; transition: background 0.3s;">
        ← Back to Dashboard
    </a>
</div>

<table border="1" style="width:100%; border-collapse: collapse; text-align: left; font-family: sans-serif;">
    <thead style="background-color:  #1E3C72FF; color: white;">
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
<%--        <td>--%>
<%--                <span style="padding: 2px 8px; border-radius: 10px; color: white; background-color: <%= room.getStatus().equals("AVAILABLE") ? "#28a745" : "#dc3545" %>;">--%>
<%--                    <%= room.getStatus() %>--%>
<%--                </span>--%>
<%--        </td>--%>
        <td>
                <span style="padding: 2px 8px; border-radius: 10px; color: white; background-color: <%= "AVAILABLE".equals(room.getStatus()) ? "#28a745" : "#dc3545" %>;">
                    <%= room.getStatus() != null ? room.getStatus() : "UNKNOWN" %>
                </span>
        </td>
        <td>
          |
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