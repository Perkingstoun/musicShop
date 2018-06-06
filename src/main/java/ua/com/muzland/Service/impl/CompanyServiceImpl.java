package ua.com.muzland.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.CompanyDAO;
import ua.com.muzland.Entity.Company;
import ua.com.muzland.Service.CompanyService;


@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO dao;
    @Override
    public void save(Company company) {
        dao.save(company);
    }

    @Override
    public Company find(int id) {
        return dao.findOne(id);
    }
}
