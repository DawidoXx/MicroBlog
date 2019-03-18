package dzikiZAfryki.dao;

import dzikiZAfryki.model.AppUser;

import java.util.List;

public interface AppUserDao {

    AppUser getUserByName(String username);

    AppUser getUserById(int id);

    boolean addNewUser(AppUser appUser);

    boolean deleteUserById(int id) throws Exception;

    List<AppUser> getUsersList();

}
