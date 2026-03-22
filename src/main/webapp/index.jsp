<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ocean View Resort - Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7f6;
        }

        /* Header & Navigation (Matching your sketch) */
        header {
            background-color: white;
            text-align: center;
            padding: 20px 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        header h1 {
            margin: 0;
            color: #1E3C72FF; /* Your theme red */
            font-size: 32px;
            letter-spacing: 2px;
        }

        nav {
            margin-top: 15px;
            border-top: 1px solid #ddd;
            border-bottom: 1px solid #ddd;
            display: flex;
            justify-content: center;
            background-color: #ffffff;
        }

        nav a {
            padding: 15px 25px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
            text-transform: uppercase;
            font-size: 14px;
            border-right: 1px solid #ddd;
            transition: background 0.3s;
        }

        nav a:last-child { border-right: none; }

        nav a:hover {
            background-color: #1E3C72FF;
            color: white;
        }

        /* Image Navigator (Carousel - 5 Photos) */
        .slider-container {
            max-width: 1000px;
            margin: 30px auto;
            position: relative;
            overflow: hidden;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            height: 450px;
        }

        .slides {
            display: flex;
            width: 500%; /* 5 photos = 500% */
            height: 100%;
            animation: slideAnimation 20s infinite;
        }

        .slides img {
            width: 20%; /* Each image takes 1/5th of the container */
            object-fit: cover;
        }

        @keyframes slideAnimation {
            0% { transform: translateX(0%); }
            20% { transform: translateX(-20%); }
            40% { transform: translateX(-40%); }
            60% { transform: translateX(-60%); }
            80% { transform: translateX(-80%); }
            100% { transform: translateX(0%); }
        }

        .welcome-text {
            text-align: center;
            padding: 40px;
            color: #444;
        }
    </style>
</head>
<body>

<header>
    <h1>OCEAN VIEW RESORT</h1>
    <nav>
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <a href="${pageContext.request.contextPath}/about">About Us</a>
    <a href="${pageContext.request.contextPath}/contact">Contact Us</a>
    <a href="${pageContext.request.contextPath}/login-page">Login</a>
    <a href="${pageContext.request.contextPath}/help">Help</a>
</nav>
</header>

<div class="slider-container">
    <div class="slides">
        <img src="https://images.unsplash.com/photo-1540541338287-41700207dee6?auto=format&fit=crop&w=1000&q=80" alt="Resort 1">
        <img src="https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9?auto=format&fit=crop&w=1000&q=80" alt="Resort 2">
        <img src="https://images.unsplash.com/photo-1566073771259-6a8506099945?auto=format&fit=crop&w=1000&q=80" alt="Resort 3">
        <img src="https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?auto=format&fit=crop&w=1000&q=80" alt="Resort 4">
        <img src="https://images.unsplash.com/photo-1544124499-58912cbddaad?auto=format&fit=crop&w=1000&q=80" alt="Resort 5">
    </div>
</div>

<div class="welcome-text">
    <h2>Experience the Ultimate Luxury</h2>
    <p>Welcome to Ocean View Resort, where the sky meets the sea.</p>
    <h2>Contact Us ,Booking & Reservations</h2>
    <h1> +94 763240577</h1>
</div>

</body>
</html>