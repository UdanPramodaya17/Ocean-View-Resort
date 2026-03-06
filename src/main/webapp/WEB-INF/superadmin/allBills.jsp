<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<h2>All Bills</h2>--%>
<%--<table border="1">--%>
<%--  <tr>--%>
<%--    <th>Reservation No</th>--%>
<%--    <th>Guest ID</th>--%>
<%--    <th>Room ID</th>--%>
<%--    <th>Check-In</th>--%>
<%--    <th>Check-Out</th>--%>
<%--    <th>Total Amount</th>--%>
<%--    <th>Payment Status</th>--%>
<%--  </tr>--%>
<%--  <c:forEach var="bill" items="${bills}">--%>
<%--    <tr>--%>
<%--      <td>${bill.reservationNumber}</td>--%>
<%--      <td>${bill.guestId}</td>--%>
<%--      <td>${bill.roomId}</td>--%>
<%--      <td>${bill.checkIn}</td>--%>
<%--      <td>${bill.checkOut}</td>--%>
<%--      <td>${bill.totalAmount}</td>--%>
<%--      <td>${bill.paymentStatus}</td>--%>
<%--    </tr>--%>
<%--  </c:forEach>--%>
<%--</table>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    overflow-x: auto; /* Enables horizontal scrolling on mobile */
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

  .text-muted {
    color: #777;
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

  /* Payment Status Badges */
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

  /* Dynamic colors based on payment status */
  .status-PAID, .status-COMPLETED {
    background-color: #e8f5e9;
    color: #2e7d32;
  }

  .status-UNPAID, .status-PENDING {
    background-color: #fff3e0;
    color: #ef6c00;
  }

  .status-FAILED, .status-CANCELLED {
    background-color: #ffebee;
    color: #c62828;
  }
</style>

<div class="table-container">
  <div class="page-header">
    <h2 class="page-title">All Bills</h2>
  </div>

  <div class="table-wrapper">
    <table class="data-table">
      <thead>
      <tr>
        <th>Reservation No</th>
        <th>Guest ID</th>
        <th>Room ID</th>
        <th>Check-In</th>
        <th>Check-Out</th>
        <th>Total Amount</th>
        <th>Payment Status</th>
      </tr>
      </thead>
      <tbody>
      <c:choose>
        <c:when test="${not empty bills}">
          <c:forEach var="bill" items="${bills}">
            <tr>
              <td class="text-bold">${bill.reservationNumber}</td>
              <td class="text-muted">#${bill.guestId}</td>
              <td class="text-muted">#${bill.roomId}</td>
              <td>${bill.checkIn}</td>
              <td>${bill.checkOut}</td>
              <td class="text-success">$${bill.totalAmount}</td>
              <td>
                                    <span class="badge-status status-${bill.paymentStatus.toString().toUpperCase().replace(' ', '_')}">
                                        ${bill.paymentStatus}
                                    </span>
              </td>
            </tr>
          </c:forEach>
        </c:when>
        <c:otherwise>
          <tr>
            <td colspan="7" class="empty-state">No bills found in the system.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
