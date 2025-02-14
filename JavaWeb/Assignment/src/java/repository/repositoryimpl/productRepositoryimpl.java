/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.repositoryimpl;
import db.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.entity.Product;
import repository.productRepository;
/**
 *
 * @author hello
 */
public class productRepositoryimpl implements productRepository{

    @Override
    public void addProduct(Product product) {
         String sql = "INSERT INTO product(nameProduct,unit,price, idCategory) VALUES (?, ?, ?, ?)";
         try {
             ConnectDB db = new ConnectDB();
             Connection con = db.openConnecion();
             PreparedStatement preparedStatement = con.prepareStatement(sql);
             preparedStatement.setString(1, product.getName());
             preparedStatement.setString(2, product.getUnit());
             preparedStatement.setDouble(3, product.getPrice());
             preparedStatement.setInt(4, product.getIdCategory());
             preparedStatement.execute();


         }catch (Exception e) {
             e.printStackTrace();
         }
    }

    @Override
    public void deleteProductByid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> GetAllProduct() {
        String sql = "Select * From product";
        List<Product> products = new ArrayList<>();
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getInt("id"));
                product.setName(rs.getString("nameProduct"));
                product.setUnit(rs.getString("unit"));
                product.setPrice(rs.getDouble("price"));
                product.setIdCategory(rs.getInt("idCategory"));
                products.add(product);
            }
            rs.close();
            preparedStatement.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
}
