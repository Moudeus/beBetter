<%-- 
    Document   : AddCategory
    Created on : Oct 18, 2024, 10:45:28 AM
    Author     : hello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Category!</h1>
        <form method="POST" action="categoryController">
            <label for="Cname">Category Name:</label>
            <input type="text" id="Cname" name="Cname" ><br><br>

            <label for="description">Description:</label>
            <input type="text" id="description" name="description"><br><br>

            <input type="submit" value="Add">

            <a href="ListCategory.jsp">
                <button type="button">Return to Category List</button>
            </a>
        </form>
    </body>
</html>
