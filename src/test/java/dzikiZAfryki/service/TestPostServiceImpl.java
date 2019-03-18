package dzikiZAfryki.service;

import dzikiZAfryki.dao.PostDao;
import dzikiZAfryki.model.AppUser;
import dzikiZAfryki.model.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-test.xml"})
@Rollback(true)
@Transactional
public class TestPostServiceImpl {

    @Autowired
    private PostService postService;

    @Test
    public void getUserTimeLinne(){
        List<Post> userTimeLine=postService.getUserTimeline(2);
        Assert.assertFalse(userTimeLine.isEmpty());
    }

    @Test
    public void addNewPost(){
        Assert.assertTrue(postService.addNewPost(2,"Alan Walker is the Best"));
    }

    @Test
    public void deletePost(){
        Assert.assertTrue(postService.deletePost(1));
    }
}

