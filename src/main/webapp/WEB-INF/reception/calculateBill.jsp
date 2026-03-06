<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<div class="container">--%>
<%--    <h2>Calculate Bill</h2>--%>

<%--    <c:if test="${not empty error}">--%>
<%--        <p style="color: red; background: #fee; padding: 10px; border-radius: 5px;">${error}</p>--%>
<%--    </c:if>--%>

<%--    <form action="${pageContext.request.contextPath}/reception/calculateBill" method="post" style="margin-bottom: 20px;">--%>
<%--        <label>Reservation Number:</label>--%>
<%--        <input type="text" name="reservationNumber" placeholder="e.g. RES-abc123" required--%>
<%--               value="${not empty bill ? bill.reservationNumber : ''}">--%>
<%--        <button type="submit">Search & Calculate</button>--%>
<%--    </form>--%>

<%--    <hr>--%>

<%--    <c:if test="${not empty bill}">--%>
<%--        <div style="border: 2px solid #2ecc71; padding: 20px; width: 400px; border-radius: 8px; background: #f9f9f9;">--%>
<%--            <h3>Bill Summary</h3>--%>
<%--            <p><strong>Reservation No:</strong> ${bill.reservationNumber}</p>--%>
<%--            <p><strong>Check-In:</strong> ${bill.checkIn}</p>--%>
<%--            <p><strong>Check-Out:</strong> ${bill.checkOut}</p>--%>
<%--            <p><strong>Status:</strong> <span class="badge">${bill.status}</span></p>--%>

<%--            <hr>--%>
<%--            <h3 style="color: #27ae60;">Total Due: $${bill.totalAmount}</h3>--%>

<%--                &lt;%&ndash; Action Button to go to Payment &ndash;%&gt;--%>
<%--            <form action="${pageContext.request.contextPath}/reception/payment" method="get">--%>
<%--                <input type="hidden" name="resId" value="${bill.reservationId}">--%>
<%--                <button type="submit" style="background-color: #27ae60; color: white; width: 100%; padding: 10px; border: none; cursor: pointer;">--%>
<%--                    Proceed to Payment--%>
<%--                </button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </c:if>--%>
<%--</div>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<style>
    .billing-container {
        max-width: 650px;
        margin: 40px auto;
        padding: 0 20px;
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }

    .page-title {
        color: #1e3c72;
        font-size: 28px;
        font-weight: 600;
        text-align: center;
        margin-bottom: 30px;
    }

    .card {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
        border: 1px solid #eaeaea;
        padding: 30px;
        margin-bottom: 25px;
    }

    .error-message {
        background-color: #ffebee;
        color: #c62828;
        border: 1px solid #ffcdd2;
        padding: 12px;
        border-radius: 6px;
        margin-bottom: 20px;
        text-align: center;
        font-size: 14px;
    }

    /* Search Form Styles */
    .search-form {
        display: flex;
        gap: 15px;
        align-items: flex-end;
    }

    .form-group {
        flex: 1;
        display: flex;
        flex-direction: column;
    }

    .form-group label {
        font-size: 14px;
        font-weight: 500;
        color: #444;
        margin-bottom: 8px;
    }

    .form-group input {
        padding: 12px 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 15px;
        transition: border-color 0.3s, box-shadow 0.3s;
        height: 45px;
    }

    .form-group input:focus {
        outline: none;
        border-color: #1e3c72;
        box-shadow: 0 0 0 3px rgba(30, 60, 114, 0.1);
    }

    .btn-primary {
        background-color: #1e3c72;
        color: white;
        padding: 0 24px;
        height: 45px;
        border: none;
        border-radius: 6px;
        font-size: 15px;
        font-weight: 600;
        cursor: pointer;
        transition: background-color 0.3s;
        white-space: nowrap;
    }

    .btn-primary:hover {
        background-color: #162c55;
    }

    /* Invoice Layout Styles */
    .invoice-header {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .bill-details {
        display: flex;
        flex-direction: column;
        gap: 15px;
        margin-bottom: 25px;
    }

    .bill-row {
        display: flex;
        justify-content: space-between;
        border-bottom: 1px dashed #e0e0e0;
        padding-bottom: 8px;
        font-size: 15px;
    }

    .bill-label {
        color: #666;
    }

    .bill-value {
        font-weight: 600;
        color: #333;
    }

    .badge {
        background-color: #e3f2fd;
        color: #1e3c72;
        padding: 4px 12px;
        border-radius: 20px;
        font-size: 12px;
        font-weight: 700;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }

    .bill-total {
        text-align: center;
        font-size: 28px;
        color: #27ae60;
        font-weight: 700;
        margin: 20px 0;
        padding-top: 20px;
        border-top: 2px solid #eaeaea;
    }

    .btn-success {
        background-color: #27ae60;
        color: white;
        width: 100%;
        padding: 14px;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.1s;
    }

    .btn-success:hover {
        background-color: #219653;
    }

    .btn-success:active {
        transform: scale(0.98);
    }

    /* Mobile Responsiveness */
    @media (max-width: 600px) {
        .search-form {
            flex-direction: column;
            align-items: stretch;
        }
        .btn-primary {
            width: 100%;
            margin-top: 10px;
        }
    }
</style>

<div class="billing-container">
    <h2 class="page-title">Billing & Checkout</h2>

    <c:if test="${not empty error}">
        <div class="error-message">
            <strong>Notice:</strong> ${error}
        </div>
    </c:if>

    <div class="card">
        <form action="${pageContext.request.contextPath}/reception/calculateBill" method="post" class="search-form">
            <div class="form-group">
                <label for="reservationNumber">Reservation Number</label>
                <input type="text" id="reservationNumber" name="reservationNumber" placeholder="e.g. RES-abc123" required
                       value="${not empty bill ? bill.reservationNumber : ''}">
            </div>
            <button type="submit" class="btn-primary">Search</button>
        </form>
    </div>

    <c:if test="${not empty bill}">
        <div class="card">
            <div class="invoice-header">
                <h3>Invoice Summary</h3>
            </div>

            <div class="bill-details">
                <div class="bill-row">
                    <span class="bill-label">Reservation No.</span>
                    <span class="bill-value">${bill.reservationNumber}</span>
                </div>
                <div class="bill-row">
                    <span class="bill-label">Check-In</span>
                    <span class="bill-value">${bill.checkIn}</span>
                </div>
                <div class="bill-row">
                    <span class="bill-label">Check-Out</span>
                    <span class="bill-value">${bill.checkOut}</span>
                </div>
                <div class="bill-row">
                    <span class="bill-label">Current Status</span>
                    <span class="badge">${bill.status}</span>
                </div>
            </div>

            <div class="bill-total">
                $${bill.totalAmount}
            </div>

            <form action="${pageContext.request.contextPath}/reception/payment" method="get">
                <input type="hidden" name="resId" value="${bill.reservationId}">
                <button type="submit" class="btn-success">
                    Proceed to Payment
                </button>
            </form>
        </div>
    </c:if>
</div>

<%@ include file="../common/footer.jsp" %>