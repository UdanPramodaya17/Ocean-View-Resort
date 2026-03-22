<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>Reservation Calendar</h2>
<div id="calendar"></div>

<link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/main.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/main.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<script>
  document.addEventListener('DOMContentLoaded', function() {
    const calendarEl = document.getElementById('calendar');
    const calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'dayGridMonth',
      events: function(fetchInfo, successCallback, failureCallback) {
        axios.get('<%= request.getContextPath() %>/calendar')
                .then(response => successCallback(response.data))
                .catch(error => failureCallback(error));
      }
    });
    calendar.render();
  });
</script>
<%@ include file="../common/footer.jsp" %>