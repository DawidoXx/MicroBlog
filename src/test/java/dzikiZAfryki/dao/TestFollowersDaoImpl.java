package dzikiZAfryki.dao;


import dzikiZAfryki.model.AppUser;
import dzikiZAfryki.model.Follower;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-test.xml"})
@Transactional
@Rollback(true)
public class TestFollowersDaoImpl {

    @Autowired
    private FollowerDao followerDao;
    @Autowired
    private AppUserDao appUserDao;


    @PersistenceContext
    EntityManager entityManager;

    @Before
    public void setUp() {

    }

    @Test
    public void addToFollweeList() {
        int uid = 2;
        boolean addFollowe = followerDao.addToFollweeList(3, uid);
        assertTrue(addFollowe);
    }

    @Test
    public void removeFromFolloweeList() {
        int uid = 4;
        int user = 5;
        if (followerDao.isOnFolloweeList(user, uid)) {
            assertTrue(followerDao.removeFromFolloweeList(user, uid));
        } else {
            assertFalse(followerDao.removeFromFolloweeList(user, uid));
        }
    }

    @Test
    public void isOnFolloweeList() {
        boolean isOnFlist = followerDao.isOnFolloweeList(5, 2);
        assertTrue(isOnFlist);
    }

    @Test
    public void showFolloweeList() {
        List<Follower> showFolloweeList = followerDao.showFolloweeList(2);

        for (Follower a : showFolloweeList) {
            AppUser followujacy = appUserDao.getUserById(a.getUserId());
            System.out.println(followujacy.getName() + " " + followujacy.getSurname());
        }
        assertFalse(showFolloweeList.isEmpty());
    }
}