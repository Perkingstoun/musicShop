package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.muzland.Entity.User;
import ua.com.muzland.Entity.UserProfile;

public interface UserProfileDAO extends JpaRepository<UserProfile,Integer> {
}
