<%@ page import="java.util.ArrayList" %>
<%@ page import="model.category" %>
<%@ page import="dal.CategoryDBContext" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
    <h2>Create a New Movie</h2>
    
    <form action="create" method="POST">
        <!-- Movie Title -->
        Title: <input type="text" name="title" required/> <br/>

        <!-- Release Date -->
        Release Date: <input type="date" name="releaseddate" required/> <br/>

        <!-- Adult Only (Checkbox) -->
        Adult Only: <input type="checkbox" name="adultonly" value="yes"/> <br/>

        <!-- Category Selection (from database) -->
        Category: 
        <select name="cname" required>
            <c:forEach items="${cts}" var="category">
                <option value="${category.name}">${category.name}</option>
            </c:forEach>
        </select> <br/>
        
        <!-- Submit Button -->
        <input type="submit" value="Save"/>
    </form>
    
</body>
</html>
