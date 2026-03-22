<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: pramo--%>
<%--  Date: 2/25/2026--%>
<%--  Time: 12:24 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="${pageContext.request.contextPath}/payment" method="post">--%>
<%--    <input type="hidden" name="reservationId" value="${reservation.reservationId}"/>--%>
<%--    Amount: <input type="number" name="amount" value="${reservation.totalAmount}" readonly/><br/>   Method:--%>
<%--    <select name="method">--%>
<%--        <option>Cash</option>--%>
<%--        <option>Card</option>--%>
<%--        <option>Online</option>--%>
<%--    </select><br/>--%>
<%--    <button type="submit">Pay</button>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<div style="max-width: 600px; margin: 40px auto; font-family: sans-serif; padding: 30px; border: 1px solid #ddd; background-color: #fafafa; box-shadow: 0 4px 8px rgba(0,0,0,0.05);">
    <h2 style="border-bottom: 2px solid #ccc; padding-bottom: 10px; color: #333; margin-top: 0;">Process Payment</h2>

    <p style="color: #666; font-size: 14px;">Complete the transaction for Reservation: <strong>${reservation.reservationNumber}</strong></p>

    <form action="${pageContext.request.contextPath}/reception/payment" method="post" style="display: flex; flex-direction: column; gap: 20px; margin-top: 20px;">

        <input type="hidden" name="reservationId" value="${reservation.reservationId}">

        <div>
            <label style="display: block; margin-bottom: 5px; color: #555; font-weight: bold;">Guest ID</label>
            <input type="text" value="${reservation.guestId}" readonly style="width: 100%; padding: 10px; border: 1px solid #ccc; background-color: #eee; box-sizing: border-box;">
        </div>

        <div>
            <label style="display: block; margin-bottom: 5px; color: #555; font-weight: bold;">Amount Due ($)</label>
            <input type="number" step="0.01" name="amount" value="${reservation.totalAmount}" required style="width: 100%; padding: 10px; border: 1px solid #ccc; font-size: 16px; box-sizing: border-box;">
        </div>

        <div>
            <label style="display: block; margin-bottom: 5px; color: #555; font-weight: bold;">Payment Method</label>
            <select name="method" required style="width: 100%; padding: 10px; border: 1px solid #ccc; font-size: 16px; box-sizing: border-box;">
                <option value="">Select Method...</option>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Cash">Cash</option>
                <option value="Bank Transfer">Bank Transfer</option>
            </select>
        </div>

        <div style="margin-top: 10px; display: flex; gap: 15px;">
            <button type="submit" style="background-color: #28a745; color: white; border: none; padding: 12px 25px; cursor: pointer; font-size: 16px; font-weight: bold; border-radius: 4px; flex: 1;">Confirm & Generate Invoice</button>
            <a href="${pageContext.request.contextPath}/reception/reservations" style="background-color: #6c757d; color: white; text-decoration: none; padding: 12px 25px; text-align: center; border-radius: 4px; flex: 1;">Cancel</a>
        </div>
    </form>
</div>

<%@ include file="../common/footer.jsp" %>