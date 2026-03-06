<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header style="background-color: #124f5a; color: white; padding: 15px 20px; display: flex; justify-content: space-between; align-items: center; box-shadow: 0 2px 4px rgba(0,0,0,0.1);">

    <div style="display: flex; align-items: center; gap: 10px;">
        <h1 style="margin: 0; font-size: 24px; letter-spacing: 1px;">Ocean View Resort, Galle</h1>
    </div>

    <nav>
        <a href="${pageContext.request.contextPath}/logout"
           style="color: white; text-decoration: none; font-weight: bold; padding: 8px 16px; border: 2px solid white; border-radius: 4px; transition: all 0.3s ease;"
           onmouseover="this.style.backgroundColor='white'; this.style.color='#5a1212';"
           onmouseout="this.style.backgroundColor='transparent'; this.style.color='white';">
            Logout
        </a>
    </nav>

</header>
<hr style="margin: 0; border: none; height: 3px; background-color: #4a0f0f;">