package ua.com.muzland.Service;

import ua.com.muzland.Entity.Category;
import ua.com.muzland.Entity.SubCategory;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    Category findById(int id);
    List<Category> findAll();




}
