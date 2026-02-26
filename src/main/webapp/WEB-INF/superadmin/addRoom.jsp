<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>Add Room</h2>
<form action="<%= request.getContextPath() %>/admin/addRoom" method="post" enctype="multipart/form-data">
    <label>Room Type:</label>
    <input type="text" name="roomType" required><br>
    <label>Price Per Night:</label>
    <input type="number" step="0.01" name="pricePerNight" required><br>
    <label>Amenities:</label>
    <input type="text" name="amenities"><br>
    <label>Quantity:</label>
    <input type="number" name="quantity" value="1" required><br>
    <label>Image:</label>
    <input type="file" name="image"><br>
    <button type="submit">Add Room</button>
</form>
<%@ include file="../common/footer.jsp" %>