package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.muzland.Entity.ProductInformation;

public interface ProductInformationDAO extends JpaRepository<ProductInformation,Integer>{
}
