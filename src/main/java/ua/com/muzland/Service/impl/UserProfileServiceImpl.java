package ua.com.muzland.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.UserProfileDAO;
import ua.com.muzland.Entity.UserProfile;
import ua.com.muzland.Service.UserProfileService;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDAO dao;

    @Override
    public void save(UserProfile userProfile) {
        dao.save(userProfile);

    }

    @Override
    public UserProfile find(int id) {
        return dao.findOne(id);
    }
}
