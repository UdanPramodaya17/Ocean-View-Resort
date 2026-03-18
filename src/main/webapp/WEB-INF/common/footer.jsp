<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .site-footer {
        background-color: #1e3c72; /* Matches your brand's deep navy blue */
        color: #ffffff;
        text-align: center;
        padding: 24px 20px;
        margin-top: 60px; /* Pushes the footer down from the main content */
        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
        border-top: 4px solid #162c55; /* Slightly darker top border for depth */
        box-shadow: 0 -4px 15px rgba(0, 0, 0, 0.05);
    }

    .site-footer p {
        margin: 0;
        font-size: 14px;
        letter-spacing: 0.5px;
        opacity: 0.9; /* Softens the white text slightly so it isn't harsh */
    }




</style>

<footer class="site-footer">
    <p>&copy; 2026 Ocean View Resort | Hotel Management System</p>

    <script>
        function confirmCheckIn(element) {
            if (confirm("Are you sure you want to Check-In this guest? This will mark the room as occupied.")) {
                element.style.pointerEvents = 'none';
                element.innerText = 'Processing...';
                element.style.backgroundColor = '#95a5a6';
                return true;
            }
            return false;
        }

        function confirmCheckOut(element) {
            if (confirm("Are you sure you want to Check-Out this guest? This will finalize the stay and release the room.")) {
                element.style.pointerEvents = 'none';
                element.innerText = 'Finishing...';
                element.style.backgroundColor = '#95a5a6';
                return true;
            }
            return false;
        }
    </script>
</footer>