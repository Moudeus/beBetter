<%@ page import="repository.repositoryimpl.productRepositoryimpl" %>
<%@ page import="model.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="repository.repositoryimpl.categoryRepositoryImpl" %>
<%@ page import="converter.ProductConverter" %>
<%@ page import="controller.dto.Productdto" %><%--
    Document   : ListProduct
    Created on : Oct 18, 2024, 10:41:35 AM
    Author     : hello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product</title>
    </head>
    <body>
        <h1>List Product</h1>
        <form method="Get">
            <table border="1">
                <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Unit</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Operations</th>
                </thead>

                <tbody>
                <%
                    productRepositoryimpl productRepositoryimpl = new productRepositoryimpl();
                    ProductConverter productCoverter = new ProductConverter();
                    List<Product> products = productRepositoryimpl.GetAllProduct();
                    if(products.size() > 0 ) {
                        for(Product product : products){
                             Productdto productdto = productCoverter.convertEntityToDto(product);

                %>
                <tr>
                    <td><%= productdto.getId()%> </td>
                    <td><%= productdto.getNameProduct()%></td>
                    <td><%= productdto.getUnit()%></td>
                    <td><%= productdto.getNameCategory() %></td>
                    <td><%= productdto.getPriceProduct()%></td>
                    <td>
                    </td>
                    <% }
                    }
                    %>
                </tr>
                </tbody>
            </table>

            <a href="AddProduct.jsp">
                <button type="button" > Add Product </button>
            </a>
            <a href="ListCategory.jsp">
                <button type="button" > List Category </button>
            </a>
        </form>
        
    </body>
</html>
