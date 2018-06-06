package ua.com.muzland.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.muzland.Entity.User;


public interface UserDAO extends JpaRepository<User,Integer> {
   User findByUsername(String username);
}
