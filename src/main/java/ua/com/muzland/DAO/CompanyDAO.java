package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.muzland.Entity.Company;

public interface CompanyDAO extends JpaRepository<Company, Integer> {
}
