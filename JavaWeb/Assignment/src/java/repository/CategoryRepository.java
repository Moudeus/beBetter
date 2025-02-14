package repository;

import model.entity.Category;

import java.util.List;

public interface CategoryRepository {
    void addCategory(Category category);

    List getAllCategory();

    String findTheCategoryById(int id);

    int FindTheCategoryByName(String categoryName);
}
