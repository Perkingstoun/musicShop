package ua.com.muzland.Service;

import ua.com.muzland.Entity.Company;

public interface CompanyService {
    void save(Company company);
    Company find(int id);
}
