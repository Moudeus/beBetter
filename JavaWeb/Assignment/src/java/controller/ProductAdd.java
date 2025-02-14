/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.entity.Product;
import repository.repositoryimpl.productRepositoryimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 *
 * @author hello
 */
public class ProductAdd extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("AddProduct.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String productName = request.getParameter("name");
        String unit = request.getParameter("unit");
        int categoryid = parseInt(request.getParameter("category"));
        double price = parseDouble(request.getParameter("price"));

        PrintWriter out = response.getWriter();
        if (productName == null || productName.isEmpty() || unit == null || unit.isEmpty() || categoryid== 0 ||  price== 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("location='AddProduct.jsp';");
            out.println("alert('Error. Enter full required field');");
            out.println("</script>");
            return;
        }

        Product product = new Product(productName,unit, price, categoryid);
        productRepositoryimpl productRepositoryimpl = new productRepositoryimpl();
        List<Product> products = productRepositoryimpl.GetAllProduct();
        boolean check = false;
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                check = true;
                break;
            }
        }
        if(check) {
            out.println("<script type=\"text/javascript\">");
            out.println("location='AddProduct.jsp';");
            out.println("alert('Error. Product name already exists');");
            out.println("</script>");
            return;
        }

        else {
            productRepositoryimpl.addProduct(product);
            out.println("<script type=\"text/javascript\">");
            out.println("location='ListProduct.jsp';");
            out.println("alert('Success');");
            out.println("</script>");
            return;
        }


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
