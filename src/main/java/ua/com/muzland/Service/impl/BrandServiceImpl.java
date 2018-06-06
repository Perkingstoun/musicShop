package ua.com.muzland.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.BrandDAO;
import ua.com.muzland.Entity.Brand;
import ua.com.muzland.Service.BrandService;

import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandDAO dao;


    @Override
    public List<Brand> findAll() {
        return dao.findAll();
    }

    @Override
    public Brand findById(int id) {
        return dao.findOne(id);
    }

    @Override
    public Brand findByName(String name) {
        List<Brand> brands = dao.findAll();
        Iterator<Brand> brandIterator = brands.iterator();
        while (brandIterator.hasNext()){
            Brand brand = brandIterator.next();
            if(brand.getBrandName().equals(name)) return brand;

        }
        return null;
    }
}
