package ua.com.muzland.Service;


import ua.com.muzland.Entity.User;


import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    User findUserByUserName(String name);

//    void update(User user);
}
