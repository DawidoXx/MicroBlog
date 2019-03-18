package dzikiZAfryki.dao.impl;

import dzikiZAfryki.dao.AppUserDao;
import dzikiZAfryki.model.AppUser;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
public class AppUserDaoImpl implements AppUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public AppUserDaoImpl() {
    }
    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public AppUser getUserById(int id) {
        try {
            Query query = entityManager.createQuery("FROM AppUser WHERE uid = '" + id + "'");
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public AppUser getUserByName(String name) {
        try {
            Query query = entityManager.createQuery("FROM AppUser WHERE name = '" + name + "'");
            return (AppUser) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<AppUser> getUsersList() {
        Query query = entityManager.createQuery("FROM AppUser");
        return (List<AppUser>) query.getResultList();
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public boolean addNewUser(AppUser appUser) {
        try {
            entityManager.persist(appUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean deleteUserById(int id) {
        try {
            Query query = entityManager.createQuery("FROM AppUser WHERE uid = " + id);
            AppUser user = (AppUser) query.getSingleResult();
            entityManager.remove(user);
        } catch (Exception c) {
            return false;
        }
        return true;
    }
}
//String queryString = "INSERT INTO \"PUBLIC\".\"USERS\"(\"USERNAME\",\"PASSWORD\",\"EMAIL\",\"NAME\",\"SURNAME\")  VALUES ('" + appUser.getUsername() + "','" + appUser.getPassword() + "','" + appUser.getEmail() + "','" + appUser.getName() + "','" + appUser.getName() + "');";