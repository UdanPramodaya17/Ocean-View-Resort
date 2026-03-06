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

<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management | Secure Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <style>
        /* Modern CSS Reset */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
            background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            color: #333;
        }

        .login-wrapper {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
        }

        .login-header {
            text-align: center;
            margin-bottom: 30px;
        }

        .login-header h2 {
            color: #1e3c72;
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 8px;
        }

        .login-header p {
            color: #666;
            font-size: 14px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-size: 14px;
            font-weight: 500;
            color: #444;
            margin-bottom: 8px;
        }

        .form-group input {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
            transition: border-color 0.3s, box-shadow 0.3s;
        }

        .form-group input:focus {
            outline: none;
            border-color: #1e3c72;
            box-shadow: 0 0 0 3px rgba(30, 60, 114, 0.1);
        }

        .btn-submit {
            width: 100%;
            padding: 14px;
            background-color: #1e3c72;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.1s;
            margin-top: 10px;
        }

        .btn-submit:hover {
            background-color: #162c55;
        }

        .btn-submit:active {
            transform: scale(0.98);
        }

        .error-message {
            margin-top: 20px;
            padding: 12px;
            background-color: #ffebee;
            color: #c62828;
            border: 1px solid #ffcdd2;
            border-radius: 6px;
            font-size: 14px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="login-wrapper">
    <div class="login-header">
        <h2>Staff Portal</h2>
        <p>Enter your credentials to manage the hotel</p>
    </div>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
        </div>

        <button type="submit" class="btn-submit">Sign In</button>
    </form>

    <c:if test="${not empty error}">
        <div class="error-message">
            <strong>Authentication Failed:</strong> ${error}
        </div>
    </c:if>
</div>

</body>
</html>