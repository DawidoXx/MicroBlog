package dzikiZAfryki.dao.impl;

import dzikiZAfryki.dao.PostDao;
import dzikiZAfryki.model.Post;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Transactional
public class PostDaoImpl implements PostDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PostDaoImpl() {
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<Post> getUserTimeline(int userId) {
        String queryString = "FROM Post WHERE UID=" + userId;
        Query query = entityManager.createQuery(queryString);
        return (List<Post>) query.getResultList();
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<Post> getFullPublicTimeline(int userId) {
        String queryString = "FROM Post";
        Query query = entityManager.createQuery(queryString);
        return (List<Post>) query.getResultList();
    }

    @Transactional
    @Override
    public boolean addNewPost(int uid, String descr) {
        Post post = new Post(uid, descr);
        try {
            entityManager.persist(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean editPost(int postId, String descr) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String strDate = sdfDate.format(date);
        Query query = entityManager.createQuery("FROM Post WHERE pid = " + postId);
        try {
            Post post = (Post) query.getSingleResult();
            post.setDescr(descr);
            post.setUpdateddate(strDate);
        } catch (NoResultException ex) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public boolean deletePost(int postId) {
        Query query = entityManager.createQuery("FROM Post WHERE pid = " + postId);
        try {
            Post post = (Post) query.getSingleResult();
            entityManager.remove(post);
        } catch (NoResultException ex) {
            return false;
        }
        return true;
    }
}
