<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Add this --%>
<%@ include file="../common/header.jsp" %>
<h2>Available Rooms</h2>
<table border="1">
    <tr>
        <th>Room Type</th>
        <th>Price</th>
        <th>Amenities</th>
        <th>Status</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.roomType}</td>
            <td>${room.pricePerNight}</td>
            <td>${room.amenities}</td>
            <td>${room.status}</td>
            <td>${room.quantity}</td>
        </tr>
    </c:forEach>
</table>
<%@ include file="../common/footer.jsp" %>