package ua.com.muzland.Service;

import ua.com.muzland.Entity.Category;
import ua.com.muzland.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    List<Product> findAll(String category);
    void save(Product product);

    Product findById(int id);
    void delete(int id);
}
