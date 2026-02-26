<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<h2>Register Reception User</h2>
<form action="<%= request.getContextPath() %>/admin/registerReception" method="post">
  <label>Full Name:</label>
  <input type="text" name="fullName" required><br>
  <label>Username:</label>
  <input type="text" name="username" required><br>
  <label>Password:</label>
  <input type="password" name="password" required><br>
  <label>Email:</label>
  <input type="email" name="email"><br>
  <button type="submit">Register</button>
</form>
<%@ include file="../common/footer.jsp" %>