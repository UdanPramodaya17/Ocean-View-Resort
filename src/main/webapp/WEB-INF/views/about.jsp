<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>About Us | Ocean View Resort</title>
  <style>
    body {
      margin: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      color: #333;
      background-color: #fcfcfc;
    }

    /* Hero Section */
    .hero-about {
      background: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)),
      url('https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?auto=format&fit=crop&w=1350&q=80');
      background-size: cover;
      background-position: center;
      height: 300px;
      display: flex;
      align-items: center;
      justify-content: center;
      color: white;
      text-align: center;
    }

    .hero-about h1 {
      font-size: 48px;
      margin: 0;
      letter-spacing: 3px;
      text-transform: uppercase;
    }

    /* Content Container */
    .container {
      max-width: 1000px;
      margin: -50px auto 50px auto;
      background: white;
      padding: 50px;
      border-radius: 10px;
      box-shadow: 0 10px 30px rgba(0,0,0,0.1);
      position: relative;
    }

    .story-section {
      text-align: center;
      line-height: 1.8;
      font-size: 18px;
      color: #555;
    }

    .highlight-text {
      color: #1E3C72FF;
      font-weight: bold;
      font-size: 24px;
      margin-bottom: 20px;
      display: block;
    }

    /* Features Grid */
    .features-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 30px;
      margin-top: 50px;
    }

    .feature-card {
      text-align: center;
      padding: 20px;
      transition: 0.3s;
    }

    .feature-card:hover {
      transform: translateY(-5px);
    }

    .feature-icon {
      font-size: 40px;
      margin-bottom: 15px;
      display: block;
    }

    .btn-home {
      display: inline-block;
      margin-top: 40px;
      padding: 12px 30px;
      background-color: #1E3C72FF;
      color: white;
      text-decoration: none;
      border-radius: 5px;
      font-weight: bold;
      transition: background 0.3s;
    }

    .btn-home:hover {
      background-color: #1E3C72FF;
    }
  </style>
</head>
<body>

<div class="hero-about">
  <h1>Our Story</h1>
</div>

<div class="container">
  <div class="story-section">
    <span class="highlight-text">Luxury Meets the Horizon</span>
    <p>
      Established in 2026, <strong style="color: #5a1212;">Ocean View Resort</strong> was born from a vision
      to create a sanctuary where the golden sands of the Western Province meet world-class hospitality.
      Whether you're here for a romantic getaway or a family retreat, we provide an experience that
      rejuvenates the soul.
    </p>

    <div class="features-grid">
      <div class="feature-card">
        <span class="feature-icon">🌊</span>
        <h3 style="color: #5a1212;">Ocean Front</h3>
        <p style="font-size: 14px;">Wake up to the soothing sound of the Indian Ocean every single morning.</p>
      </div>
      <div class="feature-card">
        <span class="feature-icon">🍽️</span>
        <h3 style="color: #5a1212;">Fine Dining</h3>
        <p style="font-size: 14px;">Exquisite local and international cuisines prepared by world-renowned chefs.</p>
      </div>
      <div class="feature-card">
        <span class="feature-icon">💆</span>
        <h3 style="color: #5a1212;">Wellness Spa</h3>
        <p style="font-size: 14px;">Relax and recharge with our signature Ayurvedic treatments.</p>
      </div>
    </div>

    <a href="${pageContext.request.contextPath}/home" class="btn-home">Back to Home</a>
  </div>
</div>

</body>
</html>