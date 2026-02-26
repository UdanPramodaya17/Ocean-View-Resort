<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>Edit Reservation</h2>
<form action="<%= request.getContextPath() %>/reception/edit" method="post">
    <input type="hidden" name="reservationId" value="${reservation.reservationId}">
    <label>Guest Name:</label>
    <input type="text" name="guestName" value="${reservation.guestName}"><br>
    <label>Room Type:</label>
    <select name="roomType">
        <option value="Single" ${reservation.roomType == 'Single' ? 'selected' : ''}>Single</option>
        <option value="Double" ${reservation.roomType == 'Double' ? 'selected' : ''}>Double</option>
        <option value="Suite" ${reservation.roomType == 'Suite' ? 'selected' : ''}>Suite</option>
    </select><br>
    <label>Check-in:</label>
    <input type="date" name="checkIn" value="${reservation.checkIn}"><br>
    <label>Check-out:</label>
    <input type="date" name="checkOut" value="${reservation.checkOut}"><br>
    <button type="submit">Update</button>
</form>
<%@ include file="../common/footer.jsp" %>