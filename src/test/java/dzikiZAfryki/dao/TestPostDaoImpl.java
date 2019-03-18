package dzikiZAfryki.dao;

import dzikiZAfryki.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-test.xml"})
@Rollback(true)
@Transactional
public class TestPostDaoImpl{

    @Autowired
    private PostDao postDao;

    @Before
    public void setUp(){
    }

    @Test
    public void getUserTimelineTest(){

        List<Post> userTimeline = postDao.getUserTimeline(1);
        for (Post a:userTimeline) {
            System.out.println(a.toString());
        }
        assertFalse(userTimeline.isEmpty());
    }

    @Test
    public void getFullPublicTimelineTest(){

        List<Post> fullPublicTimeline = postDao.getFullPublicTimeline(1);
        for (Post a:fullPublicTimeline) {
            System.out.println(a.toString());
        }
        assertFalse(fullPublicTimeline.isEmpty());
    }

    @Test
    public void addNewPostTest() {
        String descr = "Dodatkowy post dodany przez test!!!";
        int uid = 1;
        boolean addPost = postDao.addNewPost(uid,descr);
        assertTrue(addPost);
    }


    @Test
    public void editPostTest() {
        String descr = "Edytowany post przez test";
        int pid = 2;
        boolean editpost = postDao.editPost(pid,descr);
        assertTrue(editpost);
    }

    @Test
    public void deletePostTest() {
        int pid = 3;
        boolean rmPost = postDao.deletePost(pid);
        assertTrue(rmPost);
    }

    @Test
    public void deletePostTest2() {
        int pid = 13;
        boolean rmPost = postDao.deletePost(pid);
        assertFalse(rmPost);
    }


}