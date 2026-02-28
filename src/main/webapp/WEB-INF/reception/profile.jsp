<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<div class="profile-container" style="max-width: 600px; margin: 20px auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px;">
    <h2>My Account Profile</h2>

    <div class="profile-details">
        <p><strong>Username:</strong> ${sessionScope.user.username}</p>
        <p><strong>Staff Role:</strong> <span class="badge">${sessionScope.user.role}</span></p>
        <p><strong>Account Status:</strong> ${sessionScope.user.status}</p>
    </div>

    <hr>

    <div class="profile-actions">
        <a href="${pageContext.request.contextPath}/reception/edit-profile" class="btn">Edit Details</a>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" style="color: red;">Logout</a>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>