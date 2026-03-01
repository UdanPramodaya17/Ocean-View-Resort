<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<h2>Super Admin Dashboard</h2>

<ul>
    <li><a href="<%= request.getContextPath() %>/superadmin/register-admin">Register Admin</a></li>

    <li><a href="<%= request.getContextPath() %>/admin/registerReception">
        Register Reception User
    </a></li>

    <li><a href="<%= request.getContextPath() %>/admin/reservations">
        View Reservations
    </a></li>

    <li><a href="<%= request.getContextPath() %>/admin/addRoomPage">
        Add Room
    </a></li>

    <li><a href="<%= request.getContextPath() %>/admin/room-list">
        Room List
    </a></li>

    <li><a href="<%= request.getContextPath() %>/admin/allBills">
        All Bills
    </a></li>

    <li><a href="<%= request.getContextPath() %>/account">
        My Account
    </a></li>
</ul>

<%@ include file="../common/footer.jsp" %>