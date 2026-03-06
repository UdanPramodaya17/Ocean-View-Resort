<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> &lt;%&ndash; Add this &ndash;%&gt;--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>Available Rooms</h2>--%>
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>Room Type</th>--%>
<%--        <th>Price</th>--%>
<%--        <th>Amenities</th>--%>
<%--        <th>Status</th>--%>
<%--        <th>Quantity</th>--%>
<%--    </tr>--%>
<%--    <c:forEach var="room" items="${rooms}">--%>
<%--        <tr>--%>
<%--            <td>${room.roomType}</td>--%>
<%--            <td>${room.pricePerNight}</td>--%>
<%--            <td>${room.amenities}</td>--%>
<%--            <td>${room.status}</td>--%>
<%--            <td>${room.quantity}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<div style="max-width: 1200px; margin: 20px auto; padding: 20px; font-family: sans-serif;">

    <div style="display: flex; justify-content: space-between; align-items: center; border-bottom: 2px solid #ccc; padding-bottom: 15px; margin-bottom: 30px;">
        <h2 style="color: #333; margin: 0;">Room Book Reservation</h2>

        <div style="display: flex; align-items: center; gap: 10px;">
            <label style="font-size: 16px; color: #555;">Search room name</label>
            <input type="text" id="roomSearch" onkeyup="filterRooms()" placeholder="Enter room type or number..."
                   style="padding: 10px; width: 250px; border: 1px solid #aaa; border-radius: 4px;">
        </div>
    </div>

    <h3 style="color: #555; margin-bottom: 20px;">All Available Rooms</h3>

    <div id="roomContainer" style="display: grid; grid-template-columns: repeat(auto-fill, minmax(280px, 1fr)); gap: 25px;">

        <c:choose>
            <c:when test="${not empty rooms}">
                <c:forEach var="room" items="${rooms}">
                    <div class="room-card" style="border: 1px solid #ddd; border-radius: 8px; overflow: hidden; background: #fff; box-shadow: 0 4px 6px rgba(0,0,0,0.05); transition: transform 0.2s;">

                        <div style="height: 180px; background-color: #eee;">
                            <c:if test="${not empty room.imagePath}">
                                <img src="${pageContext.request.contextPath}/${room.imagePath}" alt="${room.roomType}" style="width: 100%; height: 100%; object-fit: cover;">
                            </c:if>
                            <c:if test="${empty room.imagePath}">
                                <div style="display: flex; align-items: center; justify-content: center; height: 100%; color: #aaa;">No Image</div>
                            </c:if>
                        </div>

                        <div style="padding: 15px;">
                            <h3 class="room-title" style="margin: 0 0 10px 0; color: #5a1212;">${room.roomType} - Room ${room.roomNumber}</h3>
                            <p style="margin: 5px 0; color: #666; font-size: 14px;"><strong>Price:</strong> $${room.pricePerNight} / night</p>
                            <p style="margin: 5px 0; color: #666; font-size: 14px;"><strong>Capacity:</strong> ${room.maxAdults} Adults, ${room.maxChildren} Children</p>
                            <p style="margin: 5px 0; color: #666; font-size: 14px; height: 40px; overflow: hidden;"><strong>Amenities:</strong> ${room.amenities}</p>

                            <div style="margin-top: 20px; text-align: right;">
                                <a href="${pageContext.request.contextPath}/reception/book-page?roomId=${room.roomId}&roomType=${room.roomType}"
                                   style="display: inline-block; background-color: #5a1212; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; font-weight: bold;">
                                    Book Room
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div style="grid-column: 1 / -1; text-align: center; padding: 50px; color: #888;">
                    <h3>No rooms are currently available.</h3>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>

<script>
    function filterRooms() {
        // Get the search input value and convert to lowercase
        let input = document.getElementById('roomSearch').value.toLowerCase();

        // Get all room cards
        let cards = document.getElementsByClassName('room-card');

        // Loop through all cards and hide those that don't match the search query
        for (let i = 0; i < cards.length; i++) {
            let title = cards[i].getElementsByClassName('room-title')[0];

            if (title) {
                let textValue = title.textContent || title.innerText;
                if (textValue.toLowerCase().indexOf(input) > -1) {
                    cards[i].style.display = ""; // Show card
                } else {
                    cards[i].style.display = "none"; // Hide card
                }
            }
        }
    }
</script>

<%@ include file="../common/footer.jsp" %>