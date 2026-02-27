<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>Book Reservation</h2>--%>
<%--<form action="<%= request.getContextPath() %>/reception/book" method="post">--%>
<%--    <label>Guest Name:</label>--%>
<%--    <input type="text" name="fullName" required><br>--%>
<%--    <label>Address:</label>--%>
<%--    <input type="text" name="address"><br>--%>
<%--    <label>Contact:</label>--%>
<%--    <input type="text" name="contact"><br>--%>
<%--    <label>Email:</label>--%>
<%--    <input type="email" name="email"><br>--%>
<%--    <label>Room Type:</label>--%>
<%--    <select name="roomType">--%>
<%--        <option value="Single">Single</option>--%>
<%--        <option value="Double">Double</option>--%>
<%--        <option value="Suite">Suite</option>--%>
<%--    </select><br>--%>
<%--    <label>Check-in:</label>--%>
<%--    <input type="date" name="checkIn" required><br>--%>
<%--    <label>Check-out:</label>--%>
<%--    <input type="date" name="checkOut" required><br>--%>
<%--    <button type="submit">Book</button>--%>
<%--</form>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<h2>Book Reservation</h2>

<%-- Display Error Message if exists --%>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/reception/book" method="post">
    <label>Guest Name:</label>
    <input type="text" name="fullName" required><br>

    <label>Address:</label>
    <input type="text" name="address"><br>

    <label>Contact:</label>
    <input type="text" name="contact" required><br>

    <label>Email:</label>
    <input type="email" name="email" required><br>

    <label>Room Type:</label>
    <select name="roomType">
        <option value="Single">Single</option>
        <option value="Double">Double</option>
        <option value="Suite">Suite</option>
    </select><br>

    <label>Check-in:</label>
    <input type="date" name="checkIn" id="checkIn" required><br>

    <label>Check-out:</label>
    <input type="date" name="checkOut" id="checkOut" required><br>

    <button type="submit">Confirm Booking</button>
</form>

<%@ include file="../common/footer.jsp" %>