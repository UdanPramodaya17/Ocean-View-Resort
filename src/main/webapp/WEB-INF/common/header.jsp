<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    /* Premium Header Styling */
    .resort-header {
        /* Deep ocean blue gradient based on your color */
        background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
        padding: 15px 40px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .brand-container {
        display: flex;
        align-items: center;
        gap: 15px;
    }

    .brand-icon {
        font-size: 32px;
        filter: drop-shadow(0px 2px 4px rgba(0,0,0,0.2));
    }

    .brand-text {
        display: flex;
        flex-direction: column;
    }

    .brand-title {
        margin: 0;
        font-size: 22px;
        font-weight: 700;
        letter-spacing: 1.5px;
        color: #ffffff;
        text-transform: uppercase;
        text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2);
    }

    .brand-subtitle {
        margin: 0;
        font-size: 11px;
        font-weight: 500;
        letter-spacing: 3px;
        color: #b3cde0;
        text-transform: uppercase;
        margin-top: 2px;
    }

    .logout-btn {
        color: #ffffff;
        text-decoration: none;
        font-weight: 600;
        font-size: 14px;
        padding: 10px 24px;
        border: 1px solid rgba(255, 255, 255, 0.3);
        border-radius: 50px; /* Modern pill shape */
        background: rgba(255, 255, 255, 0.05);
        backdrop-filter: blur(5px);
        transition: all 0.3s ease;
        display: flex;
        align-items: center;
        gap: 8px;
    }

    .logout-btn:hover {
        background-color: #ffffff;
        color: #1e3c72;
        border-color: #ffffff;
        box-shadow: 0 4px 12px rgba(255, 255, 255, 0.2);
        transform: translateY(-2px);
    }

    /* Luxurious Gold Accent Line */
    .header-accent-line {
        margin: 0;
        border: none;
        height: 3px;
        background: linear-gradient(90deg, #c5a059 0%, #e6d08b 50%, #c5a059 100%);
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }
</style>

<header class="resort-header">
    <div class="brand-container">
        <div class="brand-icon">🌊</div>
        <div class="brand-text">
            <h1 class="brand-title">Ocean View Resort</h1>
            <p class="brand-subtitle">Galle, Sri Lanka</p>
        </div>
    </div>

    <nav>
        <a href="${pageContext.request.contextPath}/logout" class="logout-btn">
            <span>Logout</span>
            <span>👋</span>
        </a>
    </nav>
</header>

<hr class="header-accent-line">