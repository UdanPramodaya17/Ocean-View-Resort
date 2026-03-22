<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<style>
    .edit-container {
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
    .form-text {
        font-size: 12px;
        color: #888;
        margin-top: 5px;
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
    .btn-submit:hover { background-color: #162c55; }
    .btn-submit:active { transform: scale(0.98); }
    .btn-cancel {
        display: block;
        text-align: center;
        margin-top: 15px;
        color: #666;
        text-decoration: none;
        font-size: 14px;
        font-weight: 500;
    }
    .btn-cancel:hover { color: #1e3c72; text-decoration: underline; }

    .alert { padding: 12px 15px; border-radius: 6px; font-size: 14px; text-align: center; margin-bottom: 25px; }
    .alert-error { background-color: #ffebee; color: #c62828; border: 1px solid #ffcdd2; }
</style>

<div class="edit-container">
    <div class="card">
        <h2 class="page-title">Edit Profile</h2>
        <p class="page-subtitle">Update your personal details</p>

        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-error">
            <strong>Error:</strong> <%= request.getAttribute("error") %>
        </div>
        <% } %>

        <form action="${pageContext.request.contextPath}/reception/edit-profile" method="post">
            <div class="form-group">
                <label for="fullName">Full Name</label>
                <input type="text" id="fullName" name="fullName" value="${sessionScope.user.fullName}" required>
            </div>

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" value="${sessionScope.user.username}" required>
            </div>

            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" value="${sessionScope.user.address}" required>
            </div>

            <div class="form-group">
                <label for="password">New Password</label>
                <input type="password" id="password" name="password" placeholder="Leave blank to keep current password">
                <span class="form-text">Only fill this out if you want to change your password.</span>
            </div>

            <button type="submit" class="btn-submit">Save Changes</button>
            <a href="${pageContext.request.contextPath}/reception/profile" class="btn-cancel">Cancel and Go Back</a>
        </form>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>