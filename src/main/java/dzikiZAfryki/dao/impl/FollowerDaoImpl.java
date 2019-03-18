package dzikiZAfryki.dao.impl;

import dzikiZAfryki.dao.FollowerDao;
import dzikiZAfryki.model.Follower;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Transactional
public class FollowerDaoImpl implements FollowerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public FollowerDaoImpl() {
    }

    @Override
    public boolean addToFollweeList(int userId, int uidFollow) {
        Follower follow = new Follower(userId, uidFollow);
        entityManager.persist(follow);
        return true;
    }

    @Override
    public boolean removeFromFolloweeList(int userId, int uidFollow) {
        Query query = entityManager.createQuery("FROM Follower WHERE uid = " + userId + "AND UID_FOLLOWUJE = " + uidFollow);
        try {
            Follower follower = (Follower) query.getSingleResult();
            entityManager.remove(follower);
        } catch (NoResultException ex) {
            return false;
        }
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isOnFolloweeList(int userId, int uidFollow) {
        String queryString = "FROM Follower WHERE UID_FOLLOWUJE =" + uidFollow + " AND  UID =" + userId;
        Query query = entityManager.createQuery(queryString);
        try {
            entityManager.contains((Follower) query.getSingleResult());
        } catch (NoResultException ex) {
            return false;
        }
        return true;
    }

    //KTO MNIE OBSERWUJE
    @Override
    @SuppressWarnings("unchecked")
    public List<Follower> showFolloweeList(int uidFollow) {
        //String queryString = "SELECT  a.NAME, a.SURNAME FROM AppUser a INNER JOIN AppUser a ON a.UID = f.UID WHERE f.UID_FOLLOWUJE="+userId;
        String queryString = "FROM Follower WHERE UID_FOLLOWUJE =" + uidFollow;
        Query query = entityManager.createQuery(queryString);
        return (List<Follower>) query.getResultList();
    }
}