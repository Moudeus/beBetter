<%@ page import="java.util.List" %>
<%@ page import="model.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="repository.repositoryimpl.categoryRepositoryImpl" %><%--
    Document   : ListCategory
    Created on : Oct 18, 2024, 10:44:53 AM
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
        <h1>List Of Category!</h1>
        <form method="get" >
            <table border="1">
                <thead>
                    <th>Category ID</th>
                    <th>Category Name</th>
                    <th>Description</th>
                </thead>
                <tbody>
                    <% categoryRepositoryImpl impl = new categoryRepositoryImpl();
                        List<Category> categories = impl.getAllCategory();
                      if (categories != null) {
                        for (Category category : categories) {
                    %>
                    <tr>
                    <td><%= category.getId()%></td>
                    <td><%= category.getNameCategory()%></td>
                    <td><%= category.getDescriptionCategory()%></td>
                    </tr>
                     <%     }
                        }
                     %>
                </tbody>
            </table>
            <a href="AddCategory.jsp">
                <button type="button"> Add Category </button>
            </a>

            <a href="ListProduct.jsp">
                <button type="button"> List Product </button>
            </a>

        </form>
    </body>
</html>
