<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>Book Reservation</h2>--%>
<%--<form action="<%= request.getContextPath() %>/reception/book" method="post">--%>
<%--    <label>Guest Name:</label>--%>
<%--    <input type="text" name="fullName" required><br>--%>
<%--    <label>Address:</label>--%>
<%--    <input type="text" name="address"><br>--%>
<%--    <label>Contact:</label>--%>
<%--    <input type="text" name="contact"><br>--%>
<%--    <label>Email:</label>--%>
<%--    <input type="email" name="email"><br>--%>
<%--    <label>Room Type:</label>--%>
<%--    <select name="roomType">--%>
<%--        <option value="Single">Single</option>--%>
<%--        <option value="Double">Double</option>--%>
<%--        <option value="Suite">Suite</option>--%>
<%--    </select><br>--%>
<%--    <label>Check-in:</label>--%>
<%--    <input type="date" name="checkIn" required><br>--%>
<%--    <label>Check-out:</label>--%>
<%--    <input type="date" name="checkOut" required><br>--%>
<%--    <button type="submit">Book</button>--%>
<%--</form>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<h2>Book Reservation</h2>--%>

<%--&lt;%&ndash; Display Error Message if exists &ndash;%&gt;--%>
<%--<c:if test="${not empty error}">--%>
<%--    <p style="color: red;">${error}</p>--%>
<%--</c:if>--%>

<%--<form action="${pageContext.request.contextPath}/reception/book" method="post">--%>
<%--    <label>Guest Name:</label>--%>
<%--    <input type="text" name="fullName" required><br>--%>

<%--    <label>Address:</label>--%>
<%--    <input type="text" name="address"><br>--%>

<%--    <label>Contact:</label>--%>
<%--    <input type="text" name="contact" required><br>--%>

<%--    <label>Email:</label>--%>
<%--    <input type="email" name="email" required><br>--%>

<%--    <label>Room Type:</label>--%>
<%--    <select name="roomType">--%>
<%--        <option value="Single">Single</option>--%>
<%--        <option value="Double">Double</option>--%>
<%--        <option value="Suite">Suite</option>--%>
<%--    </select><br>--%>

<%--    <label>Check-in:</label>--%>
<%--    <input type="date" name="checkIn" id="checkIn" required><br>--%>

<%--    <label>Check-out:</label>--%>
<%--    <input type="date" name="checkOut" id="checkOut" required><br>--%>

<%--    <button type="submit">Confirm Booking</button>--%>
<%--</form>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<div class="form-container" style="max-width: 800px; margin: 40px auto; font-family: sans-serif; padding: 30px; border: 1px solid #ddd; background-color: #fafafa;">
    <h2 style="border-bottom: 2px solid #ccc; padding-bottom: 10px; margin-bottom: 20px; color: #333;">Registration Form</h2>

    <%-- Display Error Message if exists --%>
    <c:if test="${not empty error}">
        <p style="color: red; background: #ffe6e6; padding: 10px; border-left: 4px solid red;">${error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/reception/book" method="post" style="display: flex; flex-direction: column; gap: 15px;">

        <input type="hidden" name="roomType" value="${param.roomType}">

        <div style="display: grid; grid-template-columns: 150px 1fr; align-items: center;">
            <label style="color: #555;">Guest name</label>
            <input type="text" name="fullName" required style="padding: 8px; border: 1px solid #ccc; width: 100%;">
        </div>

        <div style="display: grid; grid-template-columns: 150px 1fr; align-items: center;">
            <label style="color: #555;">Contact Number</label>
            <input type="text" name="contact" required style="padding: 8px; border: 1px solid #ccc; width: 100%;">
        </div>

        <div style="display: grid; grid-template-columns: 150px 1fr; align-items: center;">
            <label style="color: #555;">Email</label>
            <input type="email" name="email" required style="padding: 8px; border: 1px solid #ccc; width: 100%;">
        </div>

        <div style="display: grid; grid-template-columns: 150px 1fr; align-items: center; margin-top: 10px;">
            <label style="color: #555;">Check in</label>
            <input type="date" name="checkIn" id="checkIn" required style="padding: 8px; border: 1px solid #ccc; width: 50%;">
        </div>

        <div style="display: grid; grid-template-columns: 150px 1fr; align-items: center;">
            <label style="color: #555;">Check out</label>
            <input type="date" name="checkOut" id="checkOut" required style="padding: 8px; border: 1px solid #ccc; width: 50%;">
        </div>

        <h3 style="margin-top: 25px; border-bottom: 1px solid #ccc; padding-bottom: 5px; color: #444;">Address Details</h3>

        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 20px;">
            <div>
                <label style="display: block; margin-bottom: 5px; color: #555;">Address</label>
                <textarea name="address" rows="5" required style="width: 100%; padding: 8px; border: 1px solid #ccc; box-sizing: border-box;"></textarea>
            </div>
            <div>
                <label style="display: block; margin-bottom: 5px; color: #555;">City</label>
                <input type="text" name="city" style="width: 100%; padding: 8px; border: 1px solid #ccc; margin-bottom: 15px; box-sizing: border-box;">

                <label style="display: block; margin-bottom: 5px; color: #555;">Province</label>
                <select name="province" style="width: 100%; padding: 8px; border: 1px solid #ccc; box-sizing: border-box;">
                    <option value="">Select Province</option>
                    <option value="Western">Western</option>
                    <option value="Central">Central</option>
                    <option value="Southern">Southern</option>
                    <option value="Northern">Northern</option>
                    <option value="Eastern">Eastern</option>
                    <option value="North Western">North Western</option>
                    <option value="North Central">North Central</option>
                    <option value="Uva">Uva</option>
                    <option value="Sabaragamuwa">Sabaragamuwa</option>
                </select>
            </div>
        </div>

        <div style="margin-top: 30px; display: flex; align-items: center; gap: 20px;">
            <button type="submit" style="background-color: #5a1212; color: white; border: none; padding: 12px 30px; cursor: pointer; font-size: 16px;">Booking room</button>

            <div style="padding: 10px 20px; border: 1px solid #ccc; background: #fff; color: #555;">
                Room Type: <strong>${param.roomType != null ? param.roomType : 'Please select a room'}</strong>
            </div>
        </div>

    </form>
</div>

<%@ include file="../common/footer.jsp" %>