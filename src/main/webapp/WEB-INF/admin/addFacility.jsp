<%@ page contentType="text/html;charset=UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: pramo
  Date: 3/4/2026
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="form-container" style="max-width: 900px; margin: auto; font-family: sans-serif; padding: 20px; background-color: #f9f9f9;">
    <h2 style="color: #888; border-bottom: 1px solid #ddd; padding-bottom: 10px; font-weight: normal;">Facility Entry Form</h2>

    <div style="display: flex; gap: 40px;">
        <form action="<%= request.getContextPath() %>/admin/addFacility" method="post" style="flex: 2;">
            <label style="display: block; margin-bottom: 5px;">Name <span style="color:red">*</span></label>
            <input type="text" name="facilityName" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc;">

            <label style="display: block; margin-bottom: 5px;">Description <span style="color:red">*</span></label>
            <textarea name="facilityDesc" rows="6" required style="width: 100%; padding: 8px; border: 1px solid #ccc;"></textarea>

            <div style="margin-top: 30px;">
                <button type="submit" style="background-color: #5a1212; color: white; border: none; padding: 10px 25px; cursor: pointer; margin-right: 10px;">Save Facility</button>
                <button type="reset" style="background-color: #5a1212; color: white; border: none; padding: 10px 25px; cursor: pointer;">Reset Form</button>
            </div>
        </form>

        <div style="flex: 1; display: flex; flex-direction: column; gap: 15px;">
            <img src="path_to_image1.jpg" alt="Room View" style="width: 100%; border: 5px solid white; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <img src="path_to_image2.jpg" alt="Lounge View" style="width: 100%; border: 5px solid white; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
        </div>
    </div>
</div>