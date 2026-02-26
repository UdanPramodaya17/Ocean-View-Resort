<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Hotel Management Login</title>--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">--%>
<%--</head>--%>
<%--<body>--%>

<%--<h2>Login</h2>--%>

<%--<form action="${pageContext.request.contextPath}/login" method="post">--%>
<%--    <label>Username:</label>--%>
<%--    <input type="text" name="username" required><br><br>--%>

<%--    <label>Password:</label>--%>
<%--    <input type="password" name="password" required><br><br>--%>

<%--    <button type="submit">Login</button>--%>
<%--</form>--%>

<%--<c:if test="${not empty error}">--%>
<%--    <p style="color:red;">${error}</p>--%>
<%--</c:if>--%>

<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hotel Management Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<h2>Login</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br><br>

    <label>Password:</label>
    <input type="password" name="password" required><br><br>

    <button type="submit">Login</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

</body>
</html>