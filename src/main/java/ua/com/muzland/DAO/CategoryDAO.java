package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.muzland.Entity.Category;

public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
