<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>Reception Dashboard</h2>--%>
<%--<ul>--%>

<%--    <li>--%>
<%--        <a href="${pageContext.request.contextPath}/reception/book-page">--%>
<%--            Book Reservation--%>
<%--        </a>--%>
<%--    </li>--%>
<%--    <li>--%>
<%--        <a href="${pageContext.request.contextPath}/reception/reservations">--%>
<%--            View Reservations--%>
<%--        </a>--%>
<%--    </li>--%>

<%--    <li>--%>

<%--        <a href="${pageContext.request.contextPath}/reception/available-rooms">--%>
<%--            Available Rooms--%>
<%--        </a>--%>
<%--    </li>--%>

<%--    <li>--%>
<%--        <a href="${pageContext.request.contextPath}/reception/calculateBill">--%>
<%--            Calculate Bill--%>
<%--        </a>--%>
<%--    </li>--%>
<%--&lt;%&ndash;    <li>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="${pageContext.request.contextPath}/reception/calendar.jsp">&ndash;%&gt;--%>
<%--&lt;%&ndash;            View Reservation Calendar&ndash;%&gt;--%>
<%--&lt;%&ndash;        </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </li>&ndash;%&gt;--%>

<%--    <li>--%>
<%--        &lt;%&ndash; Change from account.jsp to /reception/profile &ndash;%&gt;--%>
<%--        <a href="${pageContext.request.contextPath}/reception/profile">--%>
<%--            My Account--%>
<%--        </a>--%>
<%--    </li>--%>
<%--</ul>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<style>
    .dashboard-container {
        max-width: 1200px;
        margin: 40px auto;
        padding: 0 20px;
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }

    .dashboard-header {
        color: #1e3c72;
        font-size: 32px;
        font-weight: 600;
        margin-bottom: 40px;
        text-align: center;
        border-bottom: 2px solid #eaeaea;
        padding-bottom: 15px;
    }

    .dashboard-grid {
        display: grid;
        /* Creates responsive columns that resize automatically */
        grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
        gap: 25px;
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .dashboard-card {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
        border: 1px solid #f0f0f0;
        transition: transform 0.2s ease, box-shadow 0.2s ease, border-color 0.2s ease;
    }

    .dashboard-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 10px 20px rgba(30, 60, 114, 0.1);
        border-color: #1e3c72;
    }

    .dashboard-card a {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        padding: 40px 20px;
        text-decoration: none;
        color: #444;
        height: 100%;
        font-weight: 600;
        font-size: 18px;
        border-radius: 12px;
    }

    .card-icon {
        font-size: 42px;
        margin-bottom: 15px;
        /* Adds a subtle fade to the emoji icons */
        opacity: 0.9;
    }

    /* Add this to your existing styles for the message section title */

</style>

<div class="dashboard-container">
    <h2 class="dashboard-header">Reception Dashboard</h2>

    <ul class="dashboard-grid">
        <li class="dashboard-card">
            <a href="${pageContext.request.contextPath}/reception/book-page">
                <span class="card-icon">📅</span>
                Book Reservation
            </a>
        </li>

        <li class="dashboard-card">
            <a href="${pageContext.request.contextPath}/reception/reservations">
                <span class="card-icon">📋</span>
                View Reservations
            </a>
        </li>

        <li class="dashboard-card">
            <a href="${pageContext.request.contextPath}/reception/available-rooms">
                <span class="card-icon">🔑</span>
                Available Rooms
            </a>
        </li>

        <li class="dashboard-card">
            <a href="${pageContext.request.contextPath}/reception/calculateBill">
                <span class="card-icon">💳</span>
                Calculate Bill
            </a>
        </li>




        <%-- I formatted your commented-out code so it matches the new style when you are ready to uncomment it --%>
        <%--
        <li class="dashboard-card">
            <a href="${pageContext.request.contextPath}/reception/calendar.jsp">
                <span class="card-icon">📆</span>
                View Reservation Calendar
            </a>
        </li>
        --%>

        <li class="dashboard-card">
            <%-- Change from account.jsp to /reception/profile --%>
            <a href="${pageContext.request.contextPath}/reception/profile">
                <span class="card-icon">👤</span>
                My Account
            </a>
        </li>
    </ul>
</div>

<%@ include file="../common/footer.jsp" %>