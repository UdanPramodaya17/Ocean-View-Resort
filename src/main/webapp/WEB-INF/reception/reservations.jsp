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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<h2>All Reservations</h2>

<%-- Debugging line --%>
<p>Total Reservations found: ${reservations.size()}</p>

<table border="1" cellpadding="10">
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
    <c:forEach var="res" items="${reservations}">
        <tr>
            <td>${res.reservationNumber}</td>
            <td>${res.guestName}</td>
            <td>${res.roomType}</td>
            <td>${res.checkIn}</td>
            <td>${res.checkOut}</td>
            <td>
                <strong>${res.status}</strong>
            </td>
            <td>$${res.totalAmount}</td>
            <td>
                    <%-- Edit link --%>
                <a href="${pageContext.request.contextPath}/reception/edit?id=${res.reservationId}">Edit</a>
                |

                    <%-- Check-In Action --%>
                <c:if test="${res.status == 'CONFIRMED' || empty res.status}">
                    <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkin&resId=${res.reservationId}&roomId=${res.roomId}"
                       style="color: green; font-weight: bold;">Check-In</a>
                </c:if>

                    <%-- Check-Out Action --%>
                <c:if test="${res.status == 'CHECKED_IN'}">
                    <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkout&resId=${res.reservationId}&roomId=${res.roomId}"
                       style="color: red; font-weight: bold;">Check-Out</a>
                </c:if>

                    <%-- Completed Status --%>
                <c:if test="${res.status == 'CHECKED_OUT'}">
                    <span style="color: gray;">Closed</span>
                </c:if>

                        <c:if test="${res.status != 'CHECKED_OUT'}">
                            <a href="${pageContext.request.contextPath}/reception/payment?resId=${res.reservationId}">
                                Collect Payment
                            </a>
                        </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="../common/footer.jsp" %>