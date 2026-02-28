<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>Reception Dashboard</h2>
<ul>

    <li>
        <a href="${pageContext.request.contextPath}/reception/book-page">
            Book Reservation
        </a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/reception/reservations">
            View Reservations
        </a>
    </li>

    <li>

        <a href="${pageContext.request.contextPath}/reception/available-rooms">
            Available Rooms
        </a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath}/reception/calculateBill">
            Calculate Bill
        </a>
    </li>
<%--    <li>--%>
<%--        <a href="${pageContext.request.contextPath}/reception/calendar.jsp">--%>
<%--            View Reservation Calendar--%>
<%--        </a>--%>
<%--    </li>--%>

    <li>
        <%-- Change from account.jsp to /reception/profile --%>
        <a href="${pageContext.request.contextPath}/reception/profile">
            My Account
        </a>
    </li>
</ul>
<%@ include file="../common/footer.jsp" %>