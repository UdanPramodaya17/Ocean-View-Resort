<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>All Reservations</h2>--%>
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>Reservation No</th>--%>
<%--        <th>Guest Name</th>--%>
<%--        <th>Room Type</th>--%>
<%--        <th>Check-In</th>--%>
<%--        <th>Check-Out</th>--%>
<%--        <th>Status</th>--%>
<%--        <th>Total</th>--%>
<%--        <th>Actions</th>--%>
<%--    </tr>--%>
<%--    &lt;%&ndash; Loop reservations from request attribute set in Servlet &ndash;%&gt;--%>
<%--    <c:forEach var="res" items="${reservations}">--%>
<%--        <tr>--%>
<%--            <td>${res.reservationNumber}</td>--%>
<%--            <td>${res.guestName}</td>--%>
<%--            <td>${res.roomType}</td>--%>
<%--            <td>${res.checkIn}</td>--%>
<%--            <td>${res.checkOut}</td>--%>
<%--            <td>${res.status}</td>--%>
<%--            <td>${res.totalAmount}</td>--%>
<%--            <td>--%>
<%--                <a href="editReservation.jsp?id=${res.reservationId}">Edit</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<h2>All Reservations</h2>--%>

<%--&lt;%&ndash; Debugging line &ndash;%&gt;--%>
<%--<p>Total Reservations found: ${reservations.size()}</p>--%>

<%--<table border="1" cellpadding="10">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Reservation No</th>--%>
<%--        <th>Guest Name</th>--%>
<%--        <th>Room Type</th>--%>
<%--        <th>Check-In</th>--%>
<%--        <th>Check-Out</th>--%>
<%--        <th>Status</th>--%>
<%--        <th>Total</th>--%>
<%--        <th>Actions</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="res" items="${reservations}">--%>
<%--        <tr>--%>
<%--            <td>${res.reservationNumber}</td>--%>
<%--            <td>${res.guestName}</td>--%>
<%--            <td>${res.roomType}</td>--%>
<%--            <td>${res.checkIn}</td>--%>
<%--            <td>${res.checkOut}</td>--%>
<%--            <td>--%>
<%--                <strong>${res.status}</strong>--%>
<%--            </td>--%>
<%--            <td>$${res.totalAmount}</td>--%>
<%--            <td>--%>
<%--                    &lt;%&ndash; Edit link &ndash;%&gt;--%>
<%--                <a href="${pageContext.request.contextPath}/reception/edit?id=${res.reservationId}">Edit</a>--%>
<%--                |--%>

<%--                    &lt;%&ndash; Check-In Action &ndash;%&gt;--%>
<%--                <c:if test="${res.status == 'CONFIRMED' || empty res.status}">--%>
<%--                    <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkin&resId=${res.reservationId}&roomId=${res.roomId}"--%>
<%--                       style="color: green; font-weight: bold;">Check-In</a>--%>
<%--                </c:if>--%>

<%--                    &lt;%&ndash; Check-Out Action &ndash;%&gt;--%>
<%--                <c:if test="${res.status == 'CHECKED_IN'}">--%>
<%--                    <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkout&resId=${res.reservationId}&roomId=${res.roomId}"--%>
<%--                       style="color: red; font-weight: bold;">Check-Out</a>--%>
<%--                </c:if>--%>

<%--                    &lt;%&ndash; Completed Status &ndash;%&gt;--%>
<%--                <c:if test="${res.status == 'CHECKED_OUT'}">--%>
<%--                    <span style="color: gray;">Closed</span>--%>
<%--                </c:if>--%>

<%--                        <c:if test="${res.status != 'CHECKED_OUT'}">--%>
<%--                            <a href="${pageContext.request.contextPath}/reception/payment?resId=${res.reservationId}">--%>
<%--                                Collect Payment--%>
<%--                            </a>--%>
<%--                        </c:if>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>





<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<div style="padding: 20px; font-family: sans-serif; max-width: 1200px; margin: auto;">--%>
<%--    <h2 style="color: #333; border-bottom: 2px solid #ccc; padding-bottom: 10px;">All Reservations</h2>--%>

<%--    &lt;%&ndash; Debugging line &ndash;%&gt;--%>
<%--    <p style="color: #666; font-weight: bold;">Total Reservations found: ${reservations.size()}</p>--%>

<%--    <table style="width: 100%; border-collapse: collapse; margin-top: 15px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); background: #fff;">--%>
<%--        <thead style="background-color: #5a1212; color: white; text-align: left;">--%>
<%--        <tr>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Reservation No</th>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Guest Name</th>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Room Type</th>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Check-In</th>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Check-Out</th>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Status</th>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Total</th>--%>
<%--            <th style="padding: 12px; border: 1px solid #ddd;">Actions</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:choose>--%>
<%--            <c:when test="${not empty reservations}">--%>
<%--                <c:forEach var="res" items="${reservations}">--%>
<%--                    <tr style="border-bottom: 1px solid #eee;">--%>
<%--                        <td style="padding: 10px;">${res.reservationNumber}</td>--%>
<%--                        <td style="padding: 10px;">${res.guestName}</td>--%>
<%--                        <td style="padding: 10px;">${res.roomType}</td>--%>
<%--                        <td style="padding: 10px;">${res.checkIn}</td>--%>
<%--                        <td style="padding: 10px;">${res.checkOut}</td>--%>

<%--                        <td style="padding: 10px;">--%>
<%--                            <span style="padding: 4px 8px; border-radius: 4px; color: white; font-size: 12px;--%>
<%--                                    background-color: ${res.status == 'CONFIRMED' ? '#17a2b8' :--%>
<%--                                    res.status == 'CHECKED_IN' ? '#28a745' : '#6c757d'};">--%>
<%--                                    ${res.status}--%>
<%--                            </span>--%>
<%--                        </td>--%>

<%--                        <td style="padding: 10px;">$${res.totalAmount}</td>--%>

<%--                        <td style="padding: 10px;">--%>
<%--                                &lt;%&ndash; Edit link &ndash;%&gt;--%>
<%--                            <a href="${pageContext.request.contextPath}/reception/edit?id=${res.reservationId}" style="color: #007bff; text-decoration: none;">Edit</a> |--%>

<%--                                &lt;%&ndash; Check-In Action &ndash;%&gt;--%>
<%--                            <c:if test="${res.status == 'CONFIRMED' || empty res.status}">--%>
<%--                                <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkin&resId=${res.reservationId}&roomId=${res.roomId}"--%>
<%--                                   style="color: #28a745; font-weight: bold; text-decoration: none; margin: 0 5px;">Check-In</a> |--%>
<%--                            </c:if>--%>

<%--                                &lt;%&ndash; Check-Out Action &ndash;%&gt;--%>
<%--                            <c:if test="${res.status == 'CHECKED_IN'}">--%>
<%--                                <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkout&resId=${res.reservationId}&roomId=${res.roomId}"--%>
<%--                                   style="color: #dc3545; font-weight: bold; text-decoration: none; margin: 0 5px;">Check-Out</a> |--%>
<%--                            </c:if>--%>

<%--                                &lt;%&ndash; Completed Status &ndash;%&gt;--%>
<%--                            <c:if test="${res.status == 'CHECKED_OUT'}">--%>
<%--                                <span style="color: gray; margin: 0 5px;">Closed</span> |--%>
<%--                            </c:if>--%>

<%--                                &lt;%&ndash; Payment Link &ndash;%&gt;--%>
<%--                            <c:if test="${res.status != 'CHECKED_OUT'}">--%>
<%--                                <a href="${pageContext.request.contextPath}/reception/payment?resId=${res.reservationId}" style="color: #ffc107; text-decoration: none; font-weight: bold;">--%>
<%--                                    Payment--%>
<%--                                </a>--%>
<%--                            </c:if>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <tr>--%>
<%--                    <td colspan="8" style="text-align: center; padding: 20px; color: #888;">No reservations found.</td>--%>
<%--                </tr>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<style>
    .table-container {
        max-width: 1200px;
        margin: 40px auto;
        padding: 0 20px;
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }

    /* Header Section */
    .page-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 30px;
        border-bottom: 2px solid #eaeaea;
        padding-bottom: 15px;
    }

    .page-title {
        color: #1e3c72;
        font-size: 28px;
        font-weight: 600;
        margin: 0;
    }

    /* Table Styles */
    .table-wrapper {
        background: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
        border: 1px solid #eaeaea;
        overflow-x: auto;
    }

    .data-table {
        width: 100%;
        border-collapse: collapse;
        text-align: left;
    }

    .data-table th {
        background-color: #1e3c72;
        color: #ffffff;
        padding: 16px;
        font-size: 14px;
        font-weight: 600;
        letter-spacing: 0.5px;
        white-space: nowrap;
    }

    .data-table th:first-child {
        border-top-left-radius: 10px;
    }

    .data-table th:last-child {
        border-top-right-radius: 10px;
    }

    .data-table td {
        padding: 16px;
        border-bottom: 1px solid #f0f0f0;
        color: #444;
        font-size: 14px;
        vertical-align: middle;
        white-space: nowrap;
    }

    .data-table tbody tr:hover {
        background-color: #f8f9fa;
        transition: background-color 0.2s ease;
    }

    .data-table tbody tr:last-child td {
        border-bottom: none;
    }

    /* Data Formatting */
    .text-bold {
        font-weight: 600;
        color: #333;
    }

    .text-success {
        font-weight: 700;
        color: #27ae60;
        font-size: 15px;
    }

    .empty-state {
        text-align: center;
        padding: 40px !important;
        color: #888;
        font-style: italic;
    }

    /* Status Badges */
    .badge-status {
        padding: 6px 12px;
        border-radius: 20px;
        font-size: 12px;
        font-weight: 700;
        text-transform: uppercase;
        letter-spacing: 0.5px;
        display: inline-block;
        background-color: #e3f2fd;
        color: #1e3c72;
    }

    .status-CONFIRMED, .status-CHECKED_IN {
        background-color: #e8f5e9;
        color: #2e7d32;
    }

    .status-PENDING {
        background-color: #fff3e0;
        color: #ef6c00;
    }

    .status-CANCELLED {
        background-color: #ffebee;
        color: #c62828;
    }

    /* Action Buttons (NEW) */
    .btn-action {
        padding: 8px 16px;
        border-radius: 5px;
        font-size: 13px;
        font-weight: 600;
        text-decoration: none;
        display: inline-block;
        transition: background-color 0.2s ease, transform 0.1s ease;
        text-align: center;
        cursor: pointer;
    }

    .btn-action:active {
        transform: scale(0.98);
    }

    .btn-checkin {
        background-color: #27ae60;
        color: white;
        border: 1px solid #219653;
    }

    .btn-checkin:hover {
        background-color: #219653;
    }

    .btn-checkout {
        background-color: #e74c3c;
        color: white;
        border: 1px solid #c0392b;
    }

    .btn-checkout:hover {
        background-color: #c0392b;
    }

    .text-muted {
        color: #95a5a6;
        font-size: 13px;
        font-style: italic;
        font-weight: 600;
    }

    .btn-payment {
        background-color: #f1c40f;
        color: #85660b;
        border: 1px solid #d4ac0d;
    }

    .btn-payment:hover {
        background-color: #f39c12;
        color: white;
    }

    .btn-disabled {
        background-color: #bdc3c7 !important;
        border-color: #95a5a6 !important;
        color: white !important;
        cursor: not-allowed !important;
        opacity: 0.7;
    }
</style>

<div class="table-container">
    <div class="page-header">
        <h2 class="page-title">All Reservations</h2>
    </div>

    <div class="table-wrapper">
        <table class="data-table">
            <thead>
            <tr>
                <th>Reservation No</th>
                <th>Guest Name</th>
                <th>Room Type</th>
                <th>Check-In</th>
                <th>Check-Out</th>
                <th>Status</th>
                <th>Total</th>
                <th>Action</th> </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty reservations}">
                    <c:forEach var="res" items="${reservations}">
                        <tr>
                            <td class="text-bold">${res.reservationNumber}</td>
                            <td>${res.guestName}</td>
                            <td>${res.roomType}</td>
                            <td>${res.checkIn}</td>
                            <td>${res.checkOut}</td>
                            <td>
                                    <span class="badge-status status-${res.status.toString().toUpperCase()}">
                                            ${res.status}
                                    </span>
                            </td>
                            <td class="text-success">රු ${res.totalAmount}</td>

                            <td>
                                <c:choose>
                                    <%-- 1. If CONFIRMED -> Show Check In Button --%>
                                    <c:when test="${res.status == 'CONFIRMED'}">
                                        <a href="${pageContext.request.contextPath}/reception/statusUpdate?resId=${res.reservationId}&roomId=${res.roomId}&action=checkin"
                                           class="btn-action btn-checkin"
                                           onclick="if(confirm('Confirm check-in? Room will be marked OCCUPIED.')) { this.style.display='none'; return true; } else { return false; }">
                                            Check In
                                        </a>
                                    </c:when>

                                    <%-- 2. If CHECKED_IN -> Check Payment Status --%>
                                    <c:when test="${res.status == 'CHECKED_IN'}">
                                        <c:choose>
                                            <%-- If Payment is PAID, allow Check Out --%>
                                            <c:when test="${res.paymentStatus == 'PAID'}">
                                                <a href="${pageContext.request.contextPath}/reception/statusUpdate?resId=${res.reservationId}&roomId=${res.roomId}&action=checkout"
                                                   class="btn-action btn-checkout"
                                                   onclick="if(confirm('Confirm check-out? Room will become AVAILABLE again.')) { this.style.display='none'; return true; } else { return false; }">
                                                    Check Out
                                                </a>
                                            </c:when>

                                            <%-- If Payment is NOT PAID, disable Check Out and show Pay Now --%>
                                            <c:otherwise>
                                                <button class="btn-action btn-disabled"
                                                        onclick="alert('Action Blocked: The customer must complete their payment before checking out.'); return false;">
                                                    Check Out
                                                </button>
                                                <a href="${pageContext.request.contextPath}/reception/payment?resId=${res.reservationId}"
                                                   class="btn-action btn-payment" style="margin-left: 5px;">
                                                    Pay Now
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>

                                    <%-- 3. If CHECKED_OUT or Cancelled -> Show Completed --%>
                                    <c:otherwise>
                                        <span class="text-muted">Completed</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="8" class="empty-state">No reservations found.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>