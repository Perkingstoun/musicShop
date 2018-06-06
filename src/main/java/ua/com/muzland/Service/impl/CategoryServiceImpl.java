package ua.com.muzland.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.CategoryDAO;
import ua.com.muzland.Entity.Category;
import ua.com.muzland.Entity.SubCategory;
import ua.com.muzland.Service.CategoryService;

import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public void save(Category category) {
        categoryDAO.save(category);

    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findOne(id);
    }



    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }


//
//    @Override
//    public Category findByName(String name) {
//        List<Category>  categories = categoryDAO.findAll();
//        Iterator<Category> categoryIterator = categories.iterator();
//
//        while (categoryIterator.hasNext()) {
//            Category category = categoryIterator.next();
//            if (category.getCategoryName() == name) return category;
//
//        }
//        Category byName = categoryDAO.findByName(name);
//        System.out.println(byName);
//        return null;
//    }


}
