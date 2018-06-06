package ua.com.muzland.Service;

import ua.com.muzland.Entity.SubCategory;

import java.util.List;

public interface SubCategoryService {
    void save(SubCategory subCategory);
    SubCategory findById(int id);
    List<SubCategory> findAll();
    SubCategory findByName(String name);
}
