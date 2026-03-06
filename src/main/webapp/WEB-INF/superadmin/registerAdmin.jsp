<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>
<%--<h2>Register Admin User</h2>--%>
<%--<form action="<%= request.getContextPath() %>/superadmin/registerAdmin" method="post">--%>
<%--    <label>Full Name:</label>--%>
<%--    <input type="text" name="fullName" required><br>--%>
<%--    <label>Username:</label>--%>
<%--    <input type="text" name="username" required><br>--%>
<%--    <label>Password:</label>--%>
<%--    <input type="password" name="password" required><br>--%>
<%--    <label>Email:</label>--%>
<%--    <input type="email" name="email"><br>--%>
<%--    <button type="submit">Register</button>--%>
<%--</form>--%>
<%--<%@ include file="../common/footer.jsp" %>--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>

<style>
    .register-container {
        max-width: 500px;
        margin: 50px auto;
        padding: 0 20px;
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }

    .card {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
        border: 1px solid #eaeaea;
        padding: 40px;
    }

    .page-title {
        color: #1e3c72;
        font-size: 26px;
        font-weight: 600;
        text-align: center;
        margin-bottom: 8px;
    }

    .page-subtitle {
        text-align: center;
        color: #666;
        font-size: 14px;
        margin-bottom: 30px;
    }

    /* Form Styles */
    .form-group {
        margin-bottom: 20px;
        display: flex;
        flex-direction: column;
    }

    .form-group label {
        font-size: 14px;
        font-weight: 500;
        color: #444;
        margin-bottom: 8px;
    }

    .form-group input {
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
</style>

<div class="register-container">
    <div class="card">
        <h2 class="page-title">Register Admin User</h2>
        <p class="page-subtitle">Create a new system administrator account</p>

        <form action="<%= request.getContextPath() %>/superadmin/registerAdmin" method="post">
            <div class="form-group">
                <label for="fullName">Full Name</label>
                <input type="text" id="fullName" name="fullName" placeholder="e.g. John Doe" required>
            </div>

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Choose a unique username" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Create a secure password" required>
            </div>

            <div class="form-group">
                <label for="email">Email Address (Optional)</label>
                <input type="email" id="email" name="email" placeholder="e.g. admin@oceanview.com">
            </div>

            <button type="submit" class="btn-submit">Register Admin</button>
        </form>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>