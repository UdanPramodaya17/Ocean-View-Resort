<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<h2>Super Admin Dashboard</h2>--%>

<%--<ul>--%>
<%--    <li><a href="<%= request.getContextPath() %>/superadmin/registerAdmin">--%>
<%--        Register Admin--%>
<%--    </a></li>--%>

<%--    <li><a href="<%= request.getContextPath() %>/admin/registerReception">--%>
<%--        Register Reception User--%>
<%--    </a></li>--%>

<%--    <li><a href="<%= request.getContextPath() %>/admin/reservations">--%>
<%--        View Reservations--%>
<%--    </a></li>--%>

<%--    <li><a href="<%= request.getContextPath() %>/admin/addRoomPage">--%>
<%--        Add Room--%>
<%--    </a></li>--%>

<%--    <li><a href="<%= request.getContextPath() %>/admin/room-list">--%>
<%--        Room List--%>
<%--    </a></li>--%>

<%--    <li><a href="<%= request.getContextPath() %>/superadmin/allBills">All Bills</a></li>--%>

<%--    <li><a href="<%= request.getContextPath() %>/account">--%>
<%--        My Account--%>
<%--    </a></li>--%>
<%--</ul>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<style>
    .dashboard-container {
        max-width: 1200px;
        margin: 40px auto;
        padding: 0 20px;
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }

    .dashboard-header {
        color: #1e3c72;
        font-size: 32px;
        font-weight: 600;
        margin-bottom: 40px;
        text-align: center;
        border-bottom: 2px solid #eaeaea;
        padding-bottom: 15px;
    }

    .dashboard-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
        gap: 25px;
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .dashboard-card {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
        border: 1px solid #f0f0f0;
        transition: transform 0.2s ease, box-shadow 0.2s ease, border-color 0.2s ease;
    }

    .dashboard-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 10px 20px rgba(30, 60, 114, 0.1);
        border-color: #1e3c72;
    }

    .dashboard-card a {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        padding: 40px 20px;
        text-decoration: none;
        color: #444;
        height: 100%;
        font-weight: 600;
        font-size: 18px;
        border-radius: 12px;
        text-align: center;
    }

    .card-icon {
        font-size: 42px;
        margin-bottom: 15px;
        opacity: 0.9;
    }
</style>

<div class="dashboard-container">
    <h2 class="dashboard-header">Super Admin Dashboard</h2>

    <ul class="dashboard-grid">
        <li class="dashboard-card">
            <a href="<%= request.getContextPath() %>/superadmin/registerAdmin">
                <span class="card-icon">🛡️</span>
                Register Admin
            </a>
        </li>

        <li class="dashboard-card">
            <a href="<%= request.getContextPath() %>/admin/registerReception">
                <span class="card-icon">👩‍💼</span>
                Register Reception
            </a>
        </li>

        <li class="dashboard-card">
            <a href="<%= request.getContextPath() %>/admin/reservations">
                <span class="card-icon">📋</span>
                View Reservations
            </a>
        </li>

        <li class="dashboard-card">
            <a href="<%= request.getContextPath() %>/admin/addRoomPage">
                <span class="card-icon">🛏️</span>
                Add Room
            </a>
        </li>

        <li class="dashboard-card">
            <a href="<%= request.getContextPath() %>/admin/room-list">
                <span class="card-icon">🏢</span>
                Room List
            </a>
        </li>

        <%-- ✅ ADDED THE MESSAGES LINK HERE --%>
        <li class="dashboard-card">
            <a href="<%= request.getContextPath() %>/superadmin/messages">
                <span class="card-icon">✉️</span>
                View Messages
            </a>
        </li>

        <li class="dashboard-card">
            <a href="<%= request.getContextPath() %>/superadmin/allBills">
                <span class="card-icon">🧾</span>
                All Bills
            </a>
        </li>



    </ul>
</div>

<%@ include file="../common/footer.jsp" %>