<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>Edit Reservation</h2>--%>
<%--<form action="<%= request.getContextPath() %>/reception/edit" method="post">--%>
<%--    <input type="hidden" name="reservationId" value="${reservation.reservationId}">--%>
<%--    <label>Guest Name:</label>--%>
<%--    <input type="text" name="guestName" value="${reservation.guestName}"><br>--%>
<%--    <label>Room Type:</label>--%>
<%--    <select name="roomType">--%>
<%--        <option value="Single" ${reservation.roomType == 'Single' ? 'selected' : ''}>Single</option>--%>
<%--        <option value="Double" ${reservation.roomType == 'Double' ? 'selected' : ''}>Double</option>--%>
<%--        <option value="Suite" ${reservation.roomType == 'Suite' ? 'selected' : ''}>Suite</option>--%>
<%--    </select><br>--%>
<%--    <label>Check-in:</label>--%>
<%--    <input type="date" name="checkIn" value="${reservation.checkIn}"><br>--%>
<%--    <label>Check-out:</label>--%>
<%--    <input type="date" name="checkOut" value="${reservation.checkOut}"><br>--%>
<%--    <button type="submit">Update</button>--%>
<%--</form>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<style>
    .edit-container {
        max-width: 550px;
        margin: 50px auto;
        padding: 0 20px;
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }

    .card {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
        border: 1px solid #eaeaea;
        padding: 40px;
    }

    .page-title {
        color: #1e3c72;
        font-size: 26px;
        font-weight: 600;
        text-align: center;
        margin-bottom: 8px;
    }

    .page-subtitle {
        text-align: center;
        color: #666;
        font-size: 14px;
        margin-bottom: 30px;
    }

    /* Form Styles */
    .form-group {
        margin-bottom: 20px;
        display: flex;
        flex-direction: column;
    }

    .form-group label {
        font-size: 14px;
        font-weight: 500;
        color: #444;
        margin-bottom: 8px;
    }

    .form-control {
        padding: 12px 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 15px;
        transition: border-color 0.3s, box-shadow 0.3s;
        font-family: inherit;
        background-color: #fff;
    }

    .form-control:focus {
        outline: none;
        border-color: #1e3c72;
        box-shadow: 0 0 0 3px rgba(30, 60, 114, 0.1);
    }

    /* specific tweak for the select dropdown */
    select.form-control {
        cursor: pointer;
        appearance: none; /* Removes default OS styling */
        background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='none' stroke='%23333' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3e%3cpolyline points='6 9 12 15 18 9'%3e%3c/polyline%3e%3c/svg%3e");
        background-repeat: no-repeat;
        background-position: right 15px center;
        background-size: 16px;
        padding-right: 40px;
    }

    .btn-submit {
        width: 100%;
        padding: 14px;
        background-color: #1e3c72;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.1s;
        margin-top: 15px;
    }

    .btn-submit:hover {
        background-color: #162c55;
    }

    .btn-submit:active {
        transform: scale(0.98);
    }

    /* Grid for side-by-side dates */
    .form-row {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 15px;
    }

    @media (max-width: 500px) {
        .form-row {
            grid-template-columns: 1fr;
        }
    }
</style>

<div class="edit-container">
    <div class="card">
        <h2 class="page-title">Edit Reservation</h2>
        <p class="page-subtitle">Update booking details for existing guests</p>

        <form action="<%= request.getContextPath() %>/reception/edit" method="post">
            <input type="hidden" name="reservationId" value="${reservation.reservationId}">

            <div class="form-group">
                <label for="guestName">Guest Name</label>
                <input type="text" id="guestName" name="guestName" class="form-control" value="${reservation.guestName}" required>
            </div>

            <div class="form-group">
                <label for="roomType">Room Type</label>
                <select id="roomType" name="roomType" class="form-control" required>
                    <option value="Single" ${reservation.roomType == 'Single' ? 'selected' : ''}>Single Room</option>
                    <option value="Double" ${reservation.roomType == 'Double' ? 'selected' : ''}>Double Room</option>
                    <option value="Suite" ${reservation.roomType == 'Suite' ? 'selected' : ''}>Luxury Suite</option>
                </select>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="checkIn">Check-in Date</label>
                    <input type="date" id="checkIn" name="checkIn" class="form-control" value="${reservation.checkIn}" required>
                </div>

                <div class="form-group">
                    <label for="checkOut">Check-out Date</label>
                    <input type="date" id="checkOut" name="checkOut" class="form-control" value="${reservation.checkOut}" required>
                </div>
            </div>

            <button type="submit" class="btn-submit">Update Reservation</button>
        </form>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>