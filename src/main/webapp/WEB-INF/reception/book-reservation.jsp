<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/24/2026
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<form action="${pageContext.request.contextPath}/reservation"
      method="post">

    <h3>Guest Details</h3>
    Full Name: <input type="text" name="fullName"/><br/>
    Address: <input type="text" name="address"/><br/>
    Contact: <input type="text" name="contact"/><br/>
    Email: <input type="email" name="email"/><br/>

    <h3>Reservation Details</h3>
    Room ID: <input type="number" name="roomId"/><br/>
    Price per Night: <input type="number" name="price"/><br/>
    Check In: <input type="date" name="checkIn"/><br/>
    Check Out: <input type="date" name="checkOut"/><br/>

    <button type="submit">Book Reservation</button>
</form>
</html>
