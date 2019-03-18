package dzikiZAfryki.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-test.xml"})
@Rollback(true)
@Transactional
public class TestAppUserService {

    @Autowired
    private UserService userService;

    @Test
    public void getUsers(){
        Assert.assertFalse(userService.getUsersList().isEmpty());
    }

    @Test
    public void getUserById(){
        Assert.assertNotNull(userService.getUserById(2));
    }
    @Test
    public void deleteUser(){
        try {
            Assert.assertTrue(userService.deleteUserById(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
