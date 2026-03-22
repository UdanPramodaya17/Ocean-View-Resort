<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <style>
    .contact-container {
      max-width: 500px;
      margin: 60px auto;
      padding: 40px;
      background: #ffffff;
      border-radius: 16px;
      box-shadow: 0 10px 40px rgba(0, 0, 0, 0.08);
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      border: 1px solid #f0f4f8;
    }

    .contact-header {
      text-align: center;
      margin-bottom: 30px;
    }

    .contact-header h3 {
      color: #1e3c72;
      font-size: 28px;
      font-weight: 700;
      margin: 0 0 8px 0;
      letter-spacing: 0.5px;
    }

    .contact-header p {
      color: #7f8c8d;
      font-size: 15px;
      margin: 0;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-input {
      width: 100%;
      padding: 14px 16px;
      border: 1px solid #e1e8ed;
      border-radius: 8px;
      font-size: 15px;
      color: #2c3e50;
      background-color: #f8fafc;
      transition: all 0.3s ease;
      box-sizing: border-box;
    }

    .form-input::placeholder {
      color: #95a5a6;
    }

    .form-input:focus {
      outline: none;
      border-color: #1e3c72;
      background-color: #ffffff;
      box-shadow: 0 0 0 4px rgba(30, 60, 114, 0.1);
    }

    textarea.form-input {
      resize: vertical;
      min-height: 120px;
    }

    .btn-submit {
      width: 100%;
      background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
      color: white;
      border: none;
      padding: 16px;
      font-size: 16px;
      font-weight: 600;
      border-radius: 8px;
      cursor: pointer;
      transition: transform 0.2s ease, box-shadow 0.2s ease;
      letter-spacing: 0.5px;
      margin-top: 10px;
    }

    .btn-submit:hover {
      transform: translateY(-2px);
      box-shadow: 0 8px 20px rgba(30, 60, 114, 0.25);
    }

    .btn-submit:active {
      transform: translateY(0);
    }

    .alert-success {
      background-color: #e8f5e9;
      color: #2e7d32;
      padding: 15px;
      border-radius: 8px;
      font-size: 15px;
      margin-bottom: 25px;
      text-align: center;
      border: 1px solid #c8e6c9;
      font-weight: 500;
    }
  </style>
</head>
<body>

<div class="contact-container">
  <div class="contact-header">
    <h3>Send us a Message</h3>
    <p>We'd love to hear from you. Reach out below!</p>
  </div>

  <%-- Shows a beautiful green success message if the form was just submitted --%>
  <c:if test="${param.success == 'MessageSent'}">
    <div class="alert-success">
      ✅ Thank you! Your message has been sent to our team.
    </div>
  </c:if>

  <form action="${pageContext.request.contextPath}/submit-message" method="POST">
    <div class="form-group">
      <input type="text" name="name" class="form-input" placeholder="Your Name" required>
    </div>

    <div class="form-group">
      <input type="email" name="email" class="form-input" placeholder="Your Email Address" required>
    </div>

    <div class="form-group">
      <input type="text" name="subject" class="form-input" placeholder="Subject" required>
    </div>

    <div class="form-group">
      <textarea name="message" class="form-input" placeholder="How can we help you today?" required></textarea>
    </div>

    <button type="submit" class="btn-submit">Send Message ✉️</button>
  </form>
</div>

</body>
</html>