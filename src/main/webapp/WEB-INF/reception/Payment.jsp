<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/25/2026
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/payment" method="post">
    <input type="hidden" name="reservationId" value="${reservation.reservationId}"/>
    Amount: <input type="number" name="amount" value="${reservation.totalAmount}" readonly/><br/>   Method:
    <select name="method">
        <option>Cash</option>
        <option>Card</option>
        <option>Online</option>
    </select><br/>
    <button type="submit">Pay</button>
</form>
</body>
</html>
