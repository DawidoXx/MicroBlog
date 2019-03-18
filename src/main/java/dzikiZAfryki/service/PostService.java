package dzikiZAfryki.service;

import dzikiZAfryki.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getUserTimeline(int userId);

    List<Post> getFullPublicTimeline(int userId);

    boolean addNewPost(int uid, String descr);

    boolean editPost(int postId, String descr);

    boolean deletePost(int postId);
}
