package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.muzland.Entity.Brand;


public interface BrandDAO extends JpaRepository<Brand,Integer> {
}
