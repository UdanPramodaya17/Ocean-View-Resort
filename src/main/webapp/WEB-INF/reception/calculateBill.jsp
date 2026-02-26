<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>Calculate Bill</h2>
<form action="<%= request.getContextPath() %>/reception/calculateBill" method="post">
    <label>Reservation Number:</label>
    <input type="text" name="reservationNumber"><br>
    <button type="submit">Calculate</button>
</form>

<c:if test="${not empty bill}">
    <p>Total Amount: ${bill.totalAmount}</p>
</c:if>
<%@ include file="../common/footer.jsp" %>