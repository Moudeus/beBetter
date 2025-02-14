package repository.repositoryimpl;

import db.ConnectDB;
import model.entity.Category;
import repository.CategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class categoryRepositoryImpl implements CategoryRepository {
    @Override
    public void addCategory(Category category) {
        String sql = "INSERT INTO category (nameCategory, descriptionCategory) VALUES (?, ?)";
        if(category.getNameCategory() != null || category.getDescriptionCategory() != null || !category.getNameCategory().isEmpty() || !category.getDescriptionCategory().isEmpty()) {
            try {
                ConnectDB connectDB = new ConnectDB();
                Connection conn = connectDB.openConnecion();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, category.getNameCategory());
                stmt.setString(2, category.getDescriptionCategory());
                stmt.executeUpdate();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Category name or description is null or empty. Cannot add to database.");
        }
    }


    @Override
    public List<Category> getAllCategory() {
        String sql = "SELECT * FROM category ";
        List<Category> categories = new ArrayList<>();
        try{
            ConnectDB connectDB = new ConnectDB();
            Connection conn = connectDB.openConnecion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("idCategory"));
                category.setNameCategory(rs.getString("nameCategory"));
                category.setDescriptionCategory(rs.getString("descriptionCategory"));
                categories.add(category);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public String findTheCategoryById(int idCategory) {
        String sql = "SELECT c.nameCategory FROM category c ";
        String where = " WHERE c.idCategory = " + idCategory;  ;
        sql += where;
        String result = null;
        try {
            ConnectDB connectDB = new ConnectDB();
            Connection conn = connectDB.openConnecion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setNameCategory(rs.getString("nameCategory"));
                result = category.getNameCategory();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

    @Override
    public int FindTheCategoryByName(String categoryName) {
        String sql = "SELECT c.idCategory FROM category c ";
        String where = "Where c.nameCategory = " + categoryName;
        sql += where;
        int result = 0;
        try {
            ConnectDB connectDB = new ConnectDB();
            Connection conn = connectDB.openConnecion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("idCategory"));
                result = category.getId();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
