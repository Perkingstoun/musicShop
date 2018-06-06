package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.muzland.Entity.SubCategory;

public interface SubCategoryDAO extends JpaRepository<SubCategory,Integer> {
}
