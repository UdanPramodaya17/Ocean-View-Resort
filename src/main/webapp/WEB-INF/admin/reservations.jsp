<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>All Reservations</h2>
<table border="1">
    <tr>
        <th>Reservation No</th>
        <th>Guest Name</th>
        <th>Room Type</th>
        <th>Check-In</th>
        <th>Check-Out</th>
        <th>Status</th>
        <th>Total</th>
    </tr>
    <c:forEach var="res" items="${reservations}">
        <tr>
            <td>${res.reservationNumber}</td>
            <td>${res.guestName}</td>
            <td>${res.roomType}</td>
            <td>${res.checkIn}</td>
            <td>${res.checkOut}</td>
            <td>${res.status}</td>
            <td>${res.totalAmount}</td>
        </tr>
    </c:forEach>
</table>
<%@ include file="../common/footer.jsp" %>