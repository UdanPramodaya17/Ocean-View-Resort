<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/header.jsp" %>

<h2>Register Reception User</h2>

<form action="<%= request.getContextPath() %>/admin/registerReception" method="post">
  <label>Username:</label>
  <input type="text" name="username" required><br><br>

  <label>Password:</label>
  <input type="password" name="password" required><br><br>

  <button type="submit">Register</button>
</form>

<% if (request.getParameter("success") != null) { %>
<p style="color: green;">Reception user registered successfully!</p>
<% } %>

<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

<%@ include file="../common/footer.jsp" %>