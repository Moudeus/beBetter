<%@ page import="java.util.ArrayList" %>
<%@ page import="model.entity.Product" %>
<%@ page import="model.entity.Category" %>
<%@ page import="repository.repositoryimpl.productRepositoryimpl" %>
<%@ page import="repository.CategoryRepository" %>
<%@ page import="repository.repositoryimpl.categoryRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%-- 
    Document   : AddProduct
    Created on : Oct 18, 2024, 10:40:45 AM
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
        <h1>Add Product!</h1>
        <form method="Post" action="ProductAdd">
            <label for="name">Product Name:</label>
            <input type="text" id="name" name="name"><br>

            <label for="unit">Unit:</label>
            <input type="text" id="unit" name="unit"><br>

            <label for="category">Category:</label>
            <select id="category" name="category">
                <% categoryRepositoryImpl categoryRepository = new categoryRepositoryImpl();
                    List<Category> categoryList = categoryRepository.getAllCategory();
                if (categoryList != null && !categoryList.isEmpty()) {
                for (Category category : categoryList) {
                %>
                <option value="<%= category.getId() %>"><%=category.getNameCategory()+ " - " + category.getDescriptionCategory()%> </option>

                <%
                        }
                    }
                %>
            </select><br>

            <label for="price">Price:</label>
            <input type="text" id="price" name="price" ><br>

            <input type="submit" value="Add">

            <a href="ListProduct.jsp">
                <button type="button">Return to Product List</button>
            </a>
        </form>

    </body>
</html>
