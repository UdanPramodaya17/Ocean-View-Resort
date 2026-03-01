<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<h2>All Bills</h2>
<table border="1">
  <tr>
    <th>Reservation No</th>
    <th>Guest ID</th>
    <th>Room ID</th>
    <th>Check-In</th>
    <th>Check-Out</th>
    <th>Total Amount</th>
    <th>Payment Status</th>
  </tr>
  <c:forEach var="bill" items="${bills}">
    <tr>
      <td>${bill.reservationNumber}</td>
      <td>${bill.guestId}</td>
      <td>${bill.roomId}</td>
      <td>${bill.checkIn}</td>
      <td>${bill.checkOut}</td>
      <td>${bill.totalAmount}</td>
      <td>${bill.paymentStatus}</td>
    </tr>
  </c:forEach>
</table>

<%@ include file="../common/footer.jsp" %>