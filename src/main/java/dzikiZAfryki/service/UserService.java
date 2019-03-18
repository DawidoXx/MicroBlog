package dzikiZAfryki.service;

import dzikiZAfryki.model.AppUser;

import java.util.List;

public interface UserService {
    AppUser getUserByName(String username);

    AppUser getUserById(int id);

    boolean addNewUser(AppUser appUser);

    boolean deleteUserById(int id) throws Exception;

    List<AppUser> getUsersList();
}
