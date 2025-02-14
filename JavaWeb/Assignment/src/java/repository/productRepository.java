/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.entity.Product;

import java.util.List;

/**
 *
 * @author hello
 */
public interface productRepository {
    void addProduct(Product product);
    void deleteProductByid(int id);
    void updateProduct();
    List<Product> GetAllProduct();
}
