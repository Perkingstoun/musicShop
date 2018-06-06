package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.muzland.Entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{
}
