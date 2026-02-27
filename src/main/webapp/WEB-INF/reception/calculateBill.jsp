<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<div class="container">
    <h2>Calculate Bill</h2>

    <c:if test="${not empty error}">
        <p style="color: red; background: #fee; padding: 10px; border-radius: 5px;">${error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/reception/calculateBill" method="post" style="margin-bottom: 20px;">
        <label>Reservation Number:</label>
        <input type="text" name="reservationNumber" placeholder="e.g. RES-abc123" required
               value="${not empty bill ? bill.reservationNumber : ''}">
        <button type="submit">Search & Calculate</button>
    </form>

    <hr>

    <c:if test="${not empty bill}">
        <div style="border: 2px solid #2ecc71; padding: 20px; width: 400px; border-radius: 8px; background: #f9f9f9;">
            <h3>Bill Summary</h3>
            <p><strong>Reservation No:</strong> ${bill.reservationNumber}</p>
            <p><strong>Check-In:</strong> ${bill.checkIn}</p>
            <p><strong>Check-Out:</strong> ${bill.checkOut}</p>
            <p><strong>Status:</strong> <span class="badge">${bill.status}</span></p>

            <hr>
            <h3 style="color: #27ae60;">Total Due: $${bill.totalAmount}</h3>

                <%-- Action Button to go to Payment --%>
            <form action="${pageContext.request.contextPath}/reception/payment" method="get">
                <input type="hidden" name="resId" value="${bill.reservationId}">
                <button type="submit" style="background-color: #27ae60; color: white; width: 100%; padding: 10px; border: none; cursor: pointer;">
                    Proceed to Payment
                </button>
            </form>
        </div>
    </c:if>
</div>

<%@ include file="../common/footer.jsp" %>