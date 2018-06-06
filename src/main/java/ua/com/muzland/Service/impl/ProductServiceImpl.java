package ua.com.muzland.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.ProductDAO;
import ua.com.muzland.Entity.Category;
import ua.com.muzland.Entity.Product;
import ua.com.muzland.Service.CategoryService;
import ua.com.muzland.Service.ProductService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO dao;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    public List<Product> findAll() {

        return dao.findAll();
    }

    @Override
    public Product findById(int id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<Product> findAll(String category) {
        List<Category> allCategories = categoryService.findAll();
        List<Product> products = dao.findAll();
        List<Product> productsCat = new ArrayList<>();
        Iterator<Product> productIterator = products.iterator();
        Product product;
        while (productIterator.hasNext()){
            product=productIterator.next();

            if (product.getSubCategory().getCategory().getCategoryName().equals(category)){
                productsCat.add(product);
            }

        }

        return productsCat;
    }
}
