package ua.com.muzland.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.SubCategoryDAO;
import ua.com.muzland.Entity.SubCategory;
import ua.com.muzland.Service.SubCategoryService;

import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryDAO dao;

    @Override
    public void save(SubCategory subCategory) {
        dao.save(subCategory);
    }

    @Override
    public SubCategory findById(int id) {
        return dao.findOne(id);
    }

    @Override
    public List<SubCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public SubCategory findByName(String name) {
        List<SubCategory>  subCategories = dao.findAll();
        Iterator<SubCategory> subCategoryIterator = subCategories.iterator();

        while (subCategoryIterator.hasNext()){
            SubCategory subCategory = subCategoryIterator.next();
            if(subCategory.getSubCategoryName().equals(name)) return subCategory;

        }

        return null;
    }
}
