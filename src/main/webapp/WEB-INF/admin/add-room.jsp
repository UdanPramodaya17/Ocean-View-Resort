<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/24/2026
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<form action="${pageContext.request.contextPath}/addRoom"
      method="post"
      enctype="multipart/form-data">

    Room Number: <input type="text" name="roomNumber"/><br/>
    Room Type:
    <select name="roomType">
        <option>Single</option>
        <option>Double</option>
        <option>Suite</option>
    </select><br/>

    Price: <input type="number" name="price"/><br/>
    Amenities: <textarea name="amenities"></textarea><br/>
    Image: <input type="file" name="image"/><br/>

    <button type="submit">Add Room</button>
</form>
</html>
