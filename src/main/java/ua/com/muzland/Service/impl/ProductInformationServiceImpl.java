package ua.com.muzland.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.ProductInformationDAO;
import ua.com.muzland.Entity.ProductInformation;
import ua.com.muzland.Service.ProductInformationService;

@Service
@Transactional
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    ProductInformationDAO dao;

//    @Override
//    public void save(ProductInformation productInformation) {
//        dao.save(productInformation);
//    }

    @Override
    public ProductInformation findById(int id) {
        return dao.findOne(id);
    }
}
