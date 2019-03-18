package dzikiZAfryki.service.impl;

import dzikiZAfryki.dao.AppUserDao;
import dzikiZAfryki.model.AppUser;
import dzikiZAfryki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserDao userDao;


    @Override
    public AppUser getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public AppUser getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean addNewUser(AppUser appUser) {
        return userDao.addNewUser(appUser);
    }

    @Override
    public boolean deleteUserById(int id) throws Exception {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<AppUser> getUsersList() {
        return userDao.getUsersList();
    }
}
