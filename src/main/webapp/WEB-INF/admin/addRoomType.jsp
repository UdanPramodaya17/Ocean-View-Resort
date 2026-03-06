<%@ page contentType="text/html;charset=UTF-8" %>
<div class="form-container" style="max-width: 900px; margin: auto; font-family: sans-serif; padding: 20px; background-color: #f9f9f9;">

    <h2 style="color: #888; border-bottom: 1px solid #ddd; padding-bottom: 10px; font-weight: normal;">Room Type Entry Form</h2>

    <div style="display: flex; gap: 40px;">
        <form action="<%= request.getContextPath() %>/admin/addRoomType" method="post" style="flex: 2;">
            <label style="display: block; margin-bottom: 5px;">Name <span style="color:red">*</span></label>
            <input type="text" name="typeName" required style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc;">

            <label style="display: block; margin-bottom: 5px;">Description <span style="color:red">*</span></label>
            <textarea name="typeDesc" rows="6" required style="width: 100%; padding: 8px; border: 1px solid #ccc;"></textarea>

            <div style="margin-top: 30px;">
                <button type="submit" style="background-color: #1E3C72FF; color: white; border: none; padding: 10px 25px; cursor: pointer; margin-right: 10px;">Save Category</button>
                <button type="reset" style="background-color: #1E3C72FF; color: white; border: none; padding: 10px 25px; cursor: pointer;">Reset Form</button>
            </div>
        </form>

        <div style="flex: 1; display: flex; flex-direction: column; gap: 15px;">
            <img src="path_to_image1.jpg" style="width: 100%; border: 5px solid white;">
            <img src="path_to_image2.jpg" style="width: 100%; border: 5px solid white;">
        </div>
    </div>
</div>