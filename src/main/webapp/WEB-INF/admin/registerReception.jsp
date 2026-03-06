<%@ page contentType="text/html;charset=UTF-8" %>
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

  /* Alert Message Styles */
  .alert {
    padding: 12px 15px;
    border-radius: 6px;
    font-size: 14px;
    text-align: center;
    margin-bottom: 25px;
  }

  .alert-success {
    background-color: #e8f5e9;
    color: #2e7d32;
    border: 1px solid #c8e6c9;
  }

  .alert-error {
    background-color: #ffebee;
    color: #c62828;
    border: 1px solid #ffcdd2;
  }
</style>

<div class="register-container">
  <div class="card">
    <h2 class="page-title">Register Staff</h2>
    <p class="page-subtitle">Create a new account for a reception desk user</p>

    <% if (request.getParameter("success") != null) { %>
    <div class="alert alert-success">
      <strong>Success!</strong> Reception user registered successfully.
    </div>
    <% } %>

    <% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-error">
      <strong>Error:</strong> <%= request.getAttribute("error") %>
    </div>
    <% } %>

    <form action="<%= request.getContextPath() %>/admin/registerReception" method="post">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Choose a username" required>
      </div>

      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Create a secure password" required>
      </div>

      <button type="submit" class="btn-submit">Register User</button>
    </form>
  </div>
</div>

<%@ include file="../common/footer.jsp" %>