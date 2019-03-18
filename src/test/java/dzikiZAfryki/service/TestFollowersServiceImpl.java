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
public class TestFollowersServiceImpl {

    @Autowired
    private FollowerService followerService;

    @Test
    public void showFolloweListTest() {
        Assert.assertNotNull(followerService.showFolloweeList(103));
    }
}

