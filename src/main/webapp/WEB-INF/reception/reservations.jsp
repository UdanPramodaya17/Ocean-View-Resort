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

<div style="padding: 20px; font-family: sans-serif; max-width: 1200px; margin: auto;">
    <h2 style="color: #333; border-bottom: 2px solid #ccc; padding-bottom: 10px;">All Reservations</h2>

    <%-- Debugging line --%>
    <p style="color: #666; font-weight: bold;">Total Reservations found: ${reservations.size()}</p>

    <table style="width: 100%; border-collapse: collapse; margin-top: 15px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); background: #fff;">
        <thead style="background-color: #5a1212; color: white; text-align: left;">
        <tr>
            <th style="padding: 12px; border: 1px solid #ddd;">Reservation No</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Guest Name</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Room Type</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Check-In</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Check-Out</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Status</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Total</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty reservations}">
                <c:forEach var="res" items="${reservations}">
                    <tr style="border-bottom: 1px solid #eee;">
                        <td style="padding: 10px;">${res.reservationNumber}</td>
                        <td style="padding: 10px;">${res.guestName}</td>
                        <td style="padding: 10px;">${res.roomType}</td>
                        <td style="padding: 10px;">${res.checkIn}</td>
                        <td style="padding: 10px;">${res.checkOut}</td>

                        <td style="padding: 10px;">
                            <span style="padding: 4px 8px; border-radius: 4px; color: white; font-size: 12px;
                                    background-color: ${res.status == 'CONFIRMED' ? '#17a2b8' :
                                    res.status == 'CHECKED_IN' ? '#28a745' : '#6c757d'};">
                                    ${res.status}
                            </span>
                        </td>

                        <td style="padding: 10px;">$${res.totalAmount}</td>

                        <td style="padding: 10px;">
                                <%-- Edit Button --%>
                            <a href="${pageContext.request.contextPath}/reception/edit?id=${res.reservationId}"
                               style="background-color: #007bff; color: white; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-size: 13px; margin: 2px; display: inline-block;">Edit</a>

                                <%-- Check-In Action Button (Turns red on click) --%>
                            <c:if test="${res.status == 'CONFIRMED' || empty res.status}">
                                <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkin&resId=${res.reservationId}&roomId=${res.roomId}"
                                   onclick="this.style.backgroundColor='#dc3545'; this.style.color='white';"
                                   style="background-color: #28a745; color: white; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-weight: bold; font-size: 13px; margin: 2px; display: inline-block; transition: 0.3s;">Check-In</a>
                            </c:if>

                                <%-- Check-Out Action Button --%>
                            <c:if test="${res.status == 'CHECKED_IN'}">
                                <a href="${pageContext.request.contextPath}/reception/statusUpdate?action=checkout&resId=${res.reservationId}&roomId=${res.roomId}"
                                   style="background-color: #dc3545; color: white; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-weight: bold; font-size: 13px; margin: 2px; display: inline-block;">Check-Out</a>
                            </c:if>

                                <%-- Completed Status --%>
                            <c:if test="${res.status == 'CHECKED_OUT'}">
                                <span style="background-color: #6c757d; color: white; padding: 6px 12px; border-radius: 4px; font-size: 13px; margin: 2px; display: inline-block;">Closed</span>
                            </c:if>

                                <%-- Payment Button --%>
                            <c:if test="${res.status != 'CHECKED_OUT'}">
                                <a href="${pageContext.request.contextPath}/reception/payment?resId=${res.reservationId}"
                                   style="background-color: #ffc107; color: #333; padding: 6px 12px; text-decoration: none; font-weight: bold; border-radius: 4px; font-size: 13px; margin: 2px; display: inline-block;">Payment</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="8" style="text-align: center; padding: 20px; color: #888;">No reservations found.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>

<%@ include file="../common/footer.jsp" %>