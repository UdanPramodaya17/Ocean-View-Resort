<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>Book Reservation</h2>
<form action="<%= request.getContextPath() %>/reception/book" method="post">
    <label>Guest Name:</label>
    <input type="text" name="guestName" required><br>
    <label>Address:</label>
    <input type="text" name="address"><br>
    <label>Contact:</label>
    <input type="text" name="contact"><br>
    <label>Email:</label>
    <input type="email" name="email"><br>
    <label>Room Type:</label>
    <select name="roomType">
        <option value="Single">Single</option>
        <option value="Double">Double</option>
        <option value="Suite">Suite</option>
    </select><br>
    <label>Check-in:</label>
    <input type="date" name="checkIn" required><br>
    <label>Check-out:</label>
    <input type="date" name="checkOut" required><br>
    <button type="submit">Book</button>
</form>
<%@ include file="../common/footer.jsp" %>