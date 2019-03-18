package dzikiZAfryki.dao;

import dzikiZAfryki.model.AppUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-test.xml")
@Transactional
@Rollback(true)
public class  TestAppUserDaoImpl {

    @Autowired
    private AppUserDao appUserDao;
    private AppUser newAppUser;
    private List<AppUser> listOfUsers;

    @Before
    public void setUp() {

    }

    @Test
    public void getAllUsers() {
        listOfUsers = (appUserDao.getUsersList());
        Assert.assertNotNull(listOfUsers);
    }

    @Test
    public void testGetUserByName() {
        newAppUser = appUserDao.getUserByName("Andrzej");
        Assert.assertNotNull(newAppUser);
    }

    @Test
    public void testGetUserById() {
        newAppUser = appUserDao.getUserById(1);
        Assert.assertNotNull(newAppUser);
    }


    @Test
    public void delUser() throws Exception {
        int a = 35;
        if (appUserDao.deleteUserById(a)) {
            Assert.assertTrue(appUserDao.deleteUserById(a));
        } else {
            Assert.assertFalse(appUserDao.deleteUserById(a));
        }
    }

    @Test
    public void addUser() {
        Random random = new Random();
        AppUser tmp = new AppUser("Tes54fdgtUsername" + random.nextInt(), "Tes54tPassword", "TestE56mail", "Test456Name", "TestS546urname");

        if (appUserDao.getUserByName(tmp.getName()) == null) {
            Assert.assertTrue(appUserDao.addNewUser(tmp));
        } else {
            Assert.assertFalse(appUserDao.addNewUser(tmp));
        }
    }
}
