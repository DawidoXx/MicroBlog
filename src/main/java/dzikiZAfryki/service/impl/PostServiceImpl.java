package dzikiZAfryki.service.impl;

import dzikiZAfryki.dao.PostDao;
import dzikiZAfryki.model.Post;
import dzikiZAfryki.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> getUserTimeline(int userId) {
        return postDao.getUserTimeline(userId);
    }

    @Override
    public List<Post> getFullPublicTimeline(int userId) {
        return postDao.getFullPublicTimeline(userId);
    }

    @Override
    public boolean addNewPost(int uid, String descr) {
        return postDao.addNewPost(uid, descr);
    }

    @Override
    public boolean editPost(int postId, String descr) {
        return postDao.editPost(postId, descr);
    }

    @Override
    public boolean deletePost(int postId) {
        return postDao.deletePost(postId);
    }
}
