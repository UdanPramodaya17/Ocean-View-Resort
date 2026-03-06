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
    /* Modern UI Styling for the Reservations Table */
    .reservations-container {
        padding: 20px;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        max-width: 1200px;
        margin: 40px auto;
    }
    .page-title {
        color: #2c3e50;
        border-bottom: 2px solid #e0e6ed;
        padding-bottom: 15px;
        margin-bottom: 10px;
        font-weight: 600;
        font-size: 2rem;
    }
    .debug-text {
        color: #7f8c8d;
        font-weight: 600;
        margin-bottom: 20px;
        font-size: 0.95rem;
    }
    .table-wrapper {
        background: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.05);
        overflow: hidden;
        border: 1px solid #eef2f5;
    }
    .modern-table {
        width: 100%;
        border-collapse: collapse;
    }
    .modern-table thead {
        background-color: #5a1212; /* Kept your original header color */
        color: white;
    }
    .modern-table th {
        padding: 16px;
        text-align: left;
        font-weight: 600;
        font-size: 0.95rem;
        letter-spacing: 0.5px;
    }
    .modern-table td {
        padding: 14px 16px;
        border-bottom: 1px solid #f0f4f8;
        color: #34495e;
        vertical-align: middle;
    }
    .modern-table tbody tr:hover {
        background-color: #f8fafc;
    }
    .status-badge {
        padding: 5px 12px;
        border-radius: 20px;
        color: white;
        font-size: 0.75rem;
        font-weight: bold;
        text-transform: uppercase;
        letter-spacing: 0.5px;
        display: inline-block;
    }
    /* Action Buttons */
    .action-btn {
        padding: 7px 14px;
        text-decoration: none;
        border-radius: 6px;
        font-size: 0.85rem;
        font-weight: 600;
        margin: 2px;
        display: inline-block;
        transition: all 0.2s ease;
        color: white;
        border: none;
        cursor: pointer;
    }
    .btn-edit { background-color: #3498db; }
    .btn-edit:hover { background-color: #2980b9; }

    .btn-checkin { background-color: #2ecc71; }
    .btn-checkin:hover { background-color: #27ae60; }

    .btn-checkout { background-color: #e74c3c; }
    .btn-checkout:hover { background-color: #c0392b; }

    .btn-payment { background-color: #f1c40f; color: #85660b; }
    .btn-payment:hover { background-color: #f39c12; color: white; }

    .badge-closed {
        background-color: #e2e8f0;
        color: #64748b;
        padding: 7px 14px;
        border-radius: 6px;
        font-size: 0.85rem;
        font-weight: 600;
        margin: 2px;
        display: inline-block;
    }
</style>

<div class="reservations-container">
    <h2 class="page-title">All Reservations</h2>

    <%-- Debugging line --%>
    <p class="debug-text">Total Reservations found: ${reservations.size()}</p>

    <div class="table-wrapper">
        <table class="modern-table">
            <thead>
            <tr>
                <th>Reservation No</th>
                <th>Guest Name</th>
                <th>Room Type</th>
                <th>Check-In</th>
                <th>Check-Out</th>
                <th>Status</th>
                <th>Total</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty reservations}">
                    <c:forEach var="res" items="${reservations}">
                        <tr>
                            <td><strong>${res.reservationNumber}</strong></td>
                            <td>${res.guestName}</td>
                            <td>${res.roomType}</td>
                            <td>${res.checkIn}</td>
                            <td>${res.checkOut}</td>

                            <td>
                                <span class="status-badge" style="background-color:
                                    ${res.status == 'CONFIRMED' ? '#3498db' :
                                            res.status == 'CHECKED_IN' ? '#2ecc71' : '#95a5a6'};">
                                        ${res.status}
                                </span>
                            </td>

                            <td><strong>රු ${res.totalAmount}</strong></td>

                            <td>
                                    <%-- Edit Button --%>
                                <a href="${pageContext.request.contextPath}/reception/edit?id=${res.reservationId}"
                                   class="action-btn btn-edit">Edit</a>

                                    <%-- Check-In Action Button (With One-Time Click Safety) --%>
                                <c:if test="${res.status == 'CONFIRMED' || empty res.status}">
                                    <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkin&resId=${res.reservationId}&roomId=${res.roomId}"
                                       onclick="this.style.pointerEvents='none'; this.innerText='Processing...'; this.style.backgroundColor='#e74c3c';"
                                       class="action-btn btn-checkin">Check-In</a>
                                </c:if>

                                    <%-- Check-Out Action Button --%>
                                <c:if test="${res.status == 'CHECKED_IN'}">
                                    <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkout&resId=${res.reservationId}&roomId=${res.roomId}"
                                       class="action-btn btn-checkout">Check-Out</a>
                                </c:if>

                                    <%-- Completed Status --%>
                                <c:if test="${res.status == 'CHECKED_OUT'}">
                                    <span class="badge-closed">Closed</span>
                                </c:if>

                                    <%-- Payment Button --%>
                                <c:if test="${res.status != 'CHECKED_OUT'}">
                                    <a href="${pageContext.request.contextPath}/reception/payment?resId=${res.reservationId}"
                                       class="action-btn btn-payment">Payment</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="8" style="text-align: center; padding: 40px; color: #94a3b8; font-size: 1.1rem;">
                            No reservations found.
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>