package controller;

import model.entity.Category;
import repository.repositoryimpl.categoryRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class categoryController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("AddCategory.jsp");
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String categoryName = request.getParameter("Cname");
        String description = request.getParameter("description");

        if(categoryName == null || categoryName.isEmpty() || description == null || description.isEmpty()) {
            writer.println("<script type=\"text/javascript\">");
            writer.println("location='AddCategory.jsp';");
            writer.println("alert('Error. Enter full required field');");
            writer.println("</script>");
            return;
        }

            Category newCategory = new Category(categoryName, description);
            categoryRepositoryImpl repository = new categoryRepositoryImpl();
            List<Category> categories = repository.getAllCategory();
            boolean check = false;
            for (Category c : categories) {
                if (c.getNameCategory().equalsIgnoreCase(categoryName)) {
                    check = true;
                    break;
                }
            }
        if (check) {
            writer.println("<script type=\"text/javascript\">");
            writer.println("location='AddCategory.jsp';");
            writer.println("alert('Error. the name Category is existing');");
            writer.println("</script>");
        } else {
            repository.addCategory(newCategory);
            writer.println("<script type=\"text/javascript\">");
            writer.println("location='ListCategory.jsp';");
            writer.println("alert('Success');");
            writer.println("</script>");
        }
    }
}
