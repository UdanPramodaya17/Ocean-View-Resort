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


<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ page import="java.util.Map" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<%--%>
<%--    // Retrieve the stats map passed from the Servlet--%>
<%--    Map<String, Integer> stats = (Map<String, Integer>) request.getAttribute("stats");--%>

<%--    // Null-check to prevent errors if the map is missing--%>
<%--    if (stats == null) {--%>
<%--        // Fallback values if the DB call failed--%>
<%--        stats = new java.util.HashMap<>();--%>
<%--        stats.put("totalRooms", 0);--%>
<%--        stats.put("availableRooms", 0);--%>
<%--        stats.put("totalFacilities", 0);--%>
<%--        stats.put("totalCategories", 0);--%>
<%--    }--%>
<%--%>--%>

<%--<div style="padding: 20px;">--%>
<%--    <h2>Admin Dashboard</h2>--%>

<%--    <div style="display: flex; gap: 20px; margin-bottom: 30px;">--%>
<%--        <div style="flex: 1; background: #fff; border-left: 5px solid #5a1212; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--            <h4 style="margin: 0; color: #888;">Total Rooms</h4>--%>
<%--            <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalRooms") %></h2>--%>
<%--        </div>--%>

<%--        <div style="flex: 1; background: #fff; border-left: 5px solid #28a745; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--            <h4 style="margin: 0; color: #888;">Available Now</h4>--%>
<%--            <h2 style="margin: 10px 0 0 0; color: #28a745;"><%= stats.get("availableRooms") %></h2>--%>
<%--        </div>--%>

<%--        <div style="flex: 1; background: #fff; border-left: 5px solid #ffc107; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--            <h4 style="margin: 0; color: #888;">Active Facilities</h4>--%>
<%--            <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalFacilities") %></h2>--%>
<%--        </div>--%>

<%--        <div style="flex: 1; background: #fff; border-left: 5px solid #17a2b8; padding: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">--%>
<%--            <h4 style="margin: 0; color: #888;">Room Types</h4>--%>
<%--            <h2 style="margin: 10px 0 0 0;"><%= stats.get("totalCategories") %></h2>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <h3>Quick Actions</h3>--%>
<%--    <ul style="line-height: 2.0;">--%>
<%--        <li><a href="<%= request.getContextPath() %>/admin/registerReception">Register Reception User</a></li>--%>
<%--        <li><a href="<%= request.getContextPath() %>/admin/reservations">View Reservations</a></li>--%>
<%--        <li><a href="<%= request.getContextPath() %>/admin/addRoomPage">Add Room</a></li>--%>
<%--        <li><a href="<%= request.getContextPath() %>/admin/allBills">All Bills</a></li>--%>
<%--        <li><a href="<%= request.getContextPath() %>/admin/addFacility">Add Facility</a></li>--%>
<%--        <li><a href="<%= request.getContextPath() %>/admin/addRoomType">Add Room Type</a></li>--%>
<%--        <li><a href="<%= request.getContextPath() %>/admin/room-list">Add List</a></li>--%>

<%--    </ul>--%>
<%--</div>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>



<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ include file="../common/header.jsp" %>

<%
    // Retrieve the stats map passed from the Servlet
    @SuppressWarnings("unchecked")
    Map<String, Integer> stats = (Map<String, Integer>) request.getAttribute("stats");

    // Null-check to prevent errors if the map is missing
    if (stats == null) {
        // Fallback values if the DB call failed
        stats = new HashMap<>();
        stats.put("totalRooms", 0);
        stats.put("availableRooms", 0);
        stats.put("totalFacilities", 0);
        stats.put("totalCategories", 0);
    }
%>

<style>
    .admin-container {
        max-width: 1200px;
        margin: 40px auto;
        padding: 0 20px;
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }

    .page-title {
        color: #1e3c72;
        font-size: 32px;
        font-weight: 600;
        margin-bottom: 30px;
        border-bottom: 2px solid #eaeaea;
        padding-bottom: 15px;
    }

    .section-title {
        color: #333;
        font-size: 22px;
        margin: 40px 0 20px 0;
        font-weight: 600;
    }

    /* --- Stats Grid Styles --- */
    .stats-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
        gap: 20px;
        margin-bottom: 40px;
    }

    .stat-card {
        background: #ffffff;
        padding: 25px 20px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
        display: flex;
        flex-direction: column;
        justify-content: center;
        transition: transform 0.2s ease;
    }

    .stat-card:hover {
        transform: translateY(-3px);
    }

    .stat-card h4 {
        margin: 0;
        color: #777;
        font-size: 14px;
        text-transform: uppercase;
        letter-spacing: 0.5px;
        font-weight: 600;
    }

    .stat-card h2 {
        margin: 10px 0 0 0;
        font-size: 36px;
        font-weight: 700;
        color: #333;
    }

    /* Accent borders for stat cards */
    .border-red { border-left: 5px solid #e74c3c; }
    .border-green { border-left: 5px solid #2ecc71; }
    .border-yellow { border-left: 5px solid #f1c40f; }
    .border-teal { border-left: 5px solid #1abc9c; }

    /* --- Action Cards Styles --- */
    .actions-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
        gap: 20px;
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .action-card {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.03);
        border: 1px solid #f0f0f0;
        transition: all 0.2s ease;
    }

    .action-card:hover {
        transform: translateY(-4px);
        box-shadow: 0 10px 20px rgba(30, 60, 114, 0.08);
        border-color: #1e3c72;
    }

    .action-link {
        display: flex;
        align-items: center;
        padding: 20px;
        text-decoration: none;
        color: #444;
        font-weight: 600;
        font-size: 16px;
        border-radius: 10px;
        height: 100%;
    }

    .action-icon {
        font-size: 24px;
        margin-right: 15px;
        background: #f8f9fa;
        width: 50px;
        height: 50px;
        display: flex;
        align-items: center;
        justify-content: center;
        border-radius: 8px;
    }
</style>

<div class="admin-container">
    <h2 class="page-title">Admin Dashboard</h2>

    <div class="stats-grid">
        <div class="stat-card border-red">
            <h4>Total Rooms</h4>
            <h2><%= stats.get("totalRooms") %></h2>
        </div>

        <div class="stat-card border-green">
            <h4>Available Now</h4>
            <h2 style="color: #27ae60;"><%= stats.get("availableRooms") %></h2>
        </div>

        <div class="stat-card border-yellow">
            <h4>Active Facilities</h4>
            <h2><%= stats.get("totalFacilities") %></h2>
        </div>

        <div class="stat-card border-teal">
            <h4>Room Types</h4>
            <h2><%= stats.get("totalCategories") %></h2>
        </div>
    </div>

    <h3 class="section-title">Quick Actions</h3>

    <div class="actions-grid">
        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/registerReception" class="action-link">
                <span class="action-icon">👩‍💼</span>
                Register Receptionist
            </a>
        </div>

        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/reservations" class="action-link">
                <span class="action-icon">📋</span>
                View All Reservations
            </a>
        </div>

        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/allBills" class="action-link">
                <span class="action-icon">🧾</span>
                View All Bills
            </a>
        </div>

        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/addRoomPage" class="action-link">
                <span class="action-icon">🛏️</span>
                Add New Room
            </a>
        </div>

        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/addRoomType" class="action-link">
                <span class="action-icon">🏷️</span>
                Add Room Type
            </a>
        </div>

        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/addFacility" class="action-link">
                <span class="action-icon">✨</span>
                Add Facility
            </a>
        </div>

        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/room-list" class="action-link">
                <span class="action-icon">🏢</span>
                Room List
            </a>
        </div>
        <div class="action-card">
            <a href="<%= request.getContextPath() %>/admin/messages" class="action-link">
                <span class="action-icon">✉️</span>
                View Messages
            </a>
        </div>

    </div>
</div>

<%@ include file="../common/footer.jsp" %>