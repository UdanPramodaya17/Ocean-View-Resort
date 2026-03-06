<%@ page import="org.example.hotel.dao.RoomDAO" %>
<%@ page import="java.util.List" %><%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>Add Room</h2>--%>
<%--<form action="<%= request.getContextPath() %>/admin/addRoom" method="post" enctype="multipart/form-data">--%>
<%--    <label>Room Number:</label>--%>
<%--    <input type="text" name="roomNumber" required><br>--%>

<%--    <label>Room Type:</label>--%>
<%--    <input type="text" name="roomType" required><br>--%>

<%--    <label>Price Per Night:</label>--%>
<%--    <input type="number" step="0.01" name="price" required><br> <!-- Name matches servlet -->--%>

<%--    <label>Amenities:</label>--%>
<%--    <input type="text" name="amenities"><br>--%>

<%--    <label>Quantity:</label>--%>
<%--    <input type="number" name="quantity" value="1" required><br>--%>

<%--    <label>Image:</label>--%>
<%--    <input type="file" name="image"><br>--%>

<%--    <button type="submit">Add Room</button>--%>
<%--</form>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>

<div class="form-container" style="max-width: 900px; margin: auto; font-family: sans-serif; padding: 20px; border: 1px solid #ddd;">
    <h2 style="color: #888; border-bottom: 1px solid #ddd; padding-bottom: 10px;">Room Entry Form</h2>

    <form action="<%= request.getContextPath() %>/admin/addRoom" method="post" enctype="multipart/form-data">

        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 20px;">

            <div>
                <label>Room Name <span style="color:red">*</span></label><br>
                <input type="text" name="roomName" required style="width: 100%; margin-bottom: 15px;">

<%--                <label>Select Room Type <span style="color:red">*</span></label><br>--%>
<%--                <select name="roomType" required style="width: 100%; margin-bottom: 15px;">--%>
<%--                    <option value="">Please Select</option>--%>
<%--                    <option value="single">Single</option>--%>
<%--                    <option value="double">Double</option>--%>
<%--                    <option value="deluxe">Deluxe</option>--%>
<%--                </select>--%>


                <label>Select Room Type <span style="color:red">*</span></label><br>
                <select name="roomType" required style="width: 100%; margin-bottom: 15px;">
                    <option value="">Please Select</option>
                    <%
                        RoomDAO dao = new RoomDAO();
                        List<String> types = dao.getAllRoomTypes();
                        for(String type : types) {
                    %>
                    <option value="<%= type %>"><%= type %></option>
                    <% } %>


                </select>

                <label>Max No. of Child <span style="color:red">*</span></label><br>
                <input type="number" name="maxChild" required style="width: 100%; margin-bottom: 15px;">

                <label>Description <span style="color:red">*</span></label><br>
                <textarea name="description" rows="4" required style="width: 100%;"></textarea>
            </div>

            <div>
                <label>Room Fare <span style="color:red">*</span></label><br>
                <input type="number" step="0.01" name="roomFare" required style="width: 100%; margin-bottom: 15px;">

                <label>Number of Beds <span style="color:red">*</span></label><br>
                <input type="number" name="numBeds" required style="width: 100%; margin-bottom: 15px;">

                <label>Max No. of Adults <span style="color:red">*</span></label><br>
                <input type="number" name="maxAdults" required style="width: 100%; margin-bottom: 15px;">

<%--                <label>Select Room Facility <span style="color:red">*</span></label><br>--%>
<%--                <div style="border: 1px solid #ccc; padding: 10px; height: 80px; overflow-y: scroll; margin-bottom: 15px;">--%>
<%--                    <input type="checkbox" name="facilities" value="WiFi"> Free WiFi<br>--%>
<%--                    <input type="checkbox" name="facilities" value="Room Service"> Room Service<br>--%>
<%--                    <input type="checkbox" name="facilities" value="Laundry"> Laundry Service<br>--%>
<%--                </div>--%>

                <label>Select Room Facility <span style="color:red">*</span></label><br>
                <div style="border: 1px solid #ccc; padding: 10px; height: 80px; overflow-y: scroll; margin-bottom: 15px;">
                    <%
                        List<String> facilities = dao.getAllFacilityNames();
                        for(String facility : facilities) {
                    %>
                    <input type="checkbox" name="amenities" value="<%= facility %>"> <%= facility %><br>
                    <% } %>
                </div>

                <label>Room Image <span style="color:red">*</span></label><br>
                <input type="file" name="roomImage" required style="width: 100%;">
            </div>
        </div>

        <div style="margin-top: 20px;">
            <button type="submit" style="background-color:  #1E3C72FF; color: white; border: none; padding: 10px 20px; cursor: pointer;">Save Room</button>
            <button type="reset" style="background-color:  #1E3C72FF; color: white; border: none; padding: 10px 20px; cursor: pointer;">Reset Form</button>
        </div>
    </form>
</div>