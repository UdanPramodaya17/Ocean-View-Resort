<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/25/2026
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<h2>Reservation Calendar</h2>
<div id="calendar"></div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            height: 'auto',
            events: function(fetchInfo, successCallback, failureCallback) {
                // Call our servlet
                axios.get('<%= request.getContextPath() %>/calendar')
                    .then(function(response) {
                        successCallback(response.data);
                    })
                    .catch(function(error) {
                        failureCallback(error);
                    });
            },
            eventClick: function(info) {
                alert("Reservation: " + info.event.title + "\nStart: " + info.event.start + "\nEnd: " + info.event.end);
            }
        });

        calendar.render();
    });
</script>
</body>
</html>