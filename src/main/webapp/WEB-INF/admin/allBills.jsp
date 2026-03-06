<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<div style="padding: 20px; font-family: sans-serif; max-width: 1200px; margin: auto;">
    <h2 style="color: #333; border-bottom: 2px solid #ccc; padding-bottom: 10px;">All Bills & Invoices</h2>

    <p style="color: #666; font-weight: bold;">Total Transactions: ${payments.size()}</p>

    <table style="width: 100%; border-collapse: collapse; margin-top: 15px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); background: #fff;">
        <thead style="background-color: #5a1212; color: white; text-align: left;">
        <tr>
            <th style="padding: 12px; border: 1px solid #ddd;">Payment ID</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Reservation No</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Guest Name</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Date & Time</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Method</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Amount</th>
            <th style="padding: 12px; border: 1px solid #ddd;">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty payments}">
                <c:forEach var="pay" items="${payments}">
                    <tr style="border-bottom: 1px solid #eee;">
                        <td style="padding: 10px;">#${pay.paymentId}</td>
                        <td style="padding: 10px; font-weight: bold;">${pay.reservationNumber}</td>
                        <td style="padding: 10px;">${pay.guestName}</td>

                        <td style="padding: 10px;">${pay.paymentDate.toString().replace('T', ' ').substring(0, 16)}</td>

                        <td style="padding: 10px;">
                            <span style="background-color: #e9ecef; padding: 4px 8px; border-radius: 4px; font-size: 12px; color: #495057;">
                                    ${pay.method}
                            </span>
                        </td>
                        <td style="padding: 10px; font-weight: bold; color: #28a745;">$${pay.amount}</td>

                        <td style="padding: 10px;">
                            <a href="${pageContext.request.contextPath}/superadmin/downloadInvoice?resId=${pay.reservationId}"
                               style="background-color: #17a2b8; color: white; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-size: 13px;">
                                Download PDF
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="7" style="text-align: center; padding: 20px; color: #888;">No payment records found.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>

<%@ include file="../common/footer.jsp" %>