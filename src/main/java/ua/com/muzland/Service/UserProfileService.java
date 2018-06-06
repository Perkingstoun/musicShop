package ua.com.muzland.Service;

import ua.com.muzland.Entity.UserProfile;

public interface UserProfileService {

    void save(UserProfile userProfile);
    UserProfile find(int id);
}
