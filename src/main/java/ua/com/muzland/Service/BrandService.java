package ua.com.muzland.Service;

import ua.com.muzland.Entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> findAll();
    Brand findById(int id);

    Brand findByName(String name);
}
