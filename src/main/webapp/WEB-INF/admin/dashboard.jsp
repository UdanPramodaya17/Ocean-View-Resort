<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<h2>Admin Dashboard</h2>--%>
<%--<ul>--%>
<%--    <li><a href="<%= request.getContextPath() %>/admin/registerReception">Register Reception User</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/admin/reservations">View Reservations</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/admin/addRoomPage">Add Room</a></li>--%>
<%--    <li><a href="<%= request.getContextPath() %>/admin/allBills">All Bills</a></li>--%>

<%--    <div style="background: #fff; border-left: 5px solid #5a1212; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--        <h4 style="margin: 0; color: #888;">Total Rooms</h4>--%>
<%--        <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalRooms") %></h2>--%>
<%--    </div>--%>

<%--    <div style="background: #fff; border-left: 5px solid #28a745; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--        <h4 style="margin: 0; color: #888;">Available Now</h4>--%>
<%--        <h2 style="margin: 10px 0 0 0; color: #28a745;"><%= stats.get("availableRooms") %></h2>--%>
<%--    </div>--%>

<%--    <div style="background: #fff; border-left: 5px solid #ffc107; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--        <h4 style="margin: 0; color: #888;">Active Facilities</h4>--%>
<%--        <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalFacilities") %></h2>--%>
<%--    </div>--%>

<%--    <div style="background: #fff; border-left: 5px solid #17a2b8; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--        <h4 style="margin: 0; color: #888;">Room Types</h4>--%>
<%--        <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalCategories") %></h2>--%>
<%--    </div>--%>
<%--</ul>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ include file="../common/header.jsp" %>

<%
    // Retrieve the stats map passed from the Servlet
    Map<String, Integer> stats = (Map<String, Integer>) request.getAttribute("stats");

    // Null-check to prevent errors if the map is missing
    if (stats == null) {
        // Fallback values if the DB call failed
        stats = new java.util.HashMap<>();
        stats.put("totalRooms", 0);
        stats.put("availableRooms", 0);
        stats.put("totalFacilities", 0);
        stats.put("totalCategories", 0);
    }
%>

<div style="padding: 20px;">
    <h2>Admin Dashboard</h2>

    <div style="display: flex; gap: 20px; margin-bottom: 30px;">
        <div style="flex: 1; background: #fff; border-left: 5px solid #5a1212; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <h4 style="margin: 0; color: #888;">Total Rooms</h4>
            <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalRooms") %></h2>
        </div>

        <div style="flex: 1; background: #fff; border-left: 5px solid #28a745; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <h4 style="margin: 0; color: #888;">Available Now</h4>
            <h2 style="margin: 10px 0 0 0; color: #28a745;"><%= stats.get("availableRooms") %></h2>
        </div>

        <div style="flex: 1; background: #fff; border-left: 5px solid #ffc107; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <h4 style="margin: 0; color: #888;">Active Facilities</h4>
            <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalFacilities") %></h2>
        </div>

        <div style="flex: 1; background: #fff; border-left: 5px solid #17a2b8; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <h4 style="margin: 0; color: #888;">Room Types</h4>
            <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalCategories") %></h2>
        </div>
    </div>

    <h3>Quick Actions</h3>
    <ul style="line-height: 2.0;">
        <li><a href="<%= request.getContextPath() %>/admin/registerReception">Register Reception User</a></li>
        <li><a href="<%= request.getContextPath() %>/admin/reservations">View Reservations</a></li>
        <li><a href="<%= request.getContextPath() %>/admin/addRoomPage">Add Room</a></li>
        <li><a href="<%= request.getContextPath() %>/admin/allBills">All Bills</a></li>
        <li><a href="<%= request.getContextPath() %>/admin/addFacility">Add Facility</a></li>
        <li><a href="<%= request.getContextPath() %>/admin/addRoomType">Add Room Type</a></li>
        <li><a href="<%= request.getContextPath() %>/admin/room-list">Add List</a></li>

    </ul>
</div>

<%@ include file="../common/footer.jsp" %>