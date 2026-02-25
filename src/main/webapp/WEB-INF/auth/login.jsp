<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 2/24/2026
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Hotel Management Login</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    <button type="submit">Login</button>
</form>

${error}

</body>
</html>