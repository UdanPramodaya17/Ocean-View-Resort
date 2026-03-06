<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ include file="../common/header.jsp" %>--%>

<%--<div class="profile-container" style="max-width: 600px; margin: 20px auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px;">--%>
<%--    <h2>My Account Profile</h2>--%>

<%--    <div class="profile-details">--%>
<%--        <p><strong>Username:</strong> ${sessionScope.user.username}</p>--%>
<%--        <p><strong>Staff Role:</strong> <span class="badge">${sessionScope.user.role}</span></p>--%>
<%--        <p><strong>Account Status:</strong> ${sessionScope.user.status}</p>--%>
<%--    </div>--%>

<%--    <hr>--%>

<%--    <div class="profile-actions">--%>
<%--        <a href="${pageContext.request.contextPath}/reception/edit-profile" class="btn">Edit Details</a>--%>
<%--        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" style="color: red;">Logout</a>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<%@ include file="../common/footer.jsp" %>--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<style>
    /* Profile Page Specific Styling */
    .profile-wrapper {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 50px 20px;
    }
    .profile-card {
        background: #ffffff;
        width: 100%;
        max-width: 450px;
        border-radius: 12px;
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
        border: 1px solid #eef2f5;
        padding: 40px 30px;
        text-align: center;
        transition: transform 0.3s ease;
    }
    .profile-card:hover {
        transform: translateY(-3px);
    }
    .profile-avatar {
        width: 85px;
        height: 85px;
        background-color: #f0f4f8;
        color: #34495e;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 3rem;
        margin: 0 auto 15px;
        box-shadow: inset 0 2px 5px rgba(0,0,0,0.05);
    }
    .profile-title {
        color: #2c3e50;
        font-size: 1.6rem;
        font-weight: 700;
        margin-bottom: 5px;
        text-transform: capitalize;
    }
    .profile-subtitle {
        color: #7f8c8d;
        font-size: 0.95rem;
        margin-bottom: 30px;
    }
    .info-group {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 16px 0;
        border-bottom: 1px solid #f0f4f8;
        text-align: left;
    }
    .info-group:last-of-type {
        border-bottom: none;
        margin-bottom: 20px;
    }
    .info-label {
        font-weight: 600;
        color: #7f8c8d;
        font-size: 0.95rem;
    }
    .info-value {
        color: #2c3e50;
        font-size: 1.05rem;
        font-weight: 600;
    }
    .badge {
        padding: 6px 14px;
        border-radius: 20px;
        color: white;
        font-size: 0.8rem;
        font-weight: 700;
        text-transform: uppercase;
        letter-spacing: 0.5px;
        display: inline-block;
    }
    .badge-role {
        background-color: #3498db; /* Professional Blue */
    }
    .badge-status {
        background-color: #2ecc71; /* Active Green */
    }
    .action-buttons {
        display: flex;
        gap: 15px;
        margin-top: 10px;
    }
    .btn-profile {
        flex: 1;
        padding: 12px 0;
        text-decoration: none;
        border-radius: 8px;
        font-weight: 600;
        font-size: 1rem;
        transition: all 0.2s ease;
        text-align: center;
        cursor: pointer;
    }
    .btn-edit {
        background-color: #f8fafc;
        color: #334155;
        border: 1px solid #cbd5e1;
    }
    .btn-edit:hover {
        background-color: #e2e8f0;
        color: #0f172a;
    }
    .btn-logout {
        background-color: #fee2e2;
        color: #ef4444;
        border: 1px solid #fca5a5;
    }
    .btn-logout:hover {
        background-color: #ef4444;
        color: white;
    }
</style>

<div class="profile-wrapper">
    <div class="profile-card">

        <div class="profile-avatar">👤</div>

        <div class="profile-title">${sessionScope.user.username}</div>
        <div class="profile-subtitle">Reception Dashboard Access</div>

        <div class="info-group">
            <span class="info-label">Staff Role</span>
            <span class="info-value">
                <span class="badge badge-role">${sessionScope.user.role}</span>
            </span>
        </div>

        <div class="info-group">
            <span class="info-label">Account Status</span>
            <span class="info-value">
                <span class="badge" style="background-color: ${sessionScope.user.status == 'Active' ? '#2ecc71' : '#e74c3c'};">
                    ${sessionScope.user.status}
                </span>
            </span>
        </div>

        <div class="action-buttons">
            <a href="${pageContext.request.contextPath}/reception/edit-profile" class="btn-profile btn-edit">Edit Details</a>
            <a href="${pageContext.request.contextPath}/logout" class="btn-profile btn-logout">Logout</a>
        </div>

    </div>
</div>

<%@ include file="../common/footer.jsp" %>