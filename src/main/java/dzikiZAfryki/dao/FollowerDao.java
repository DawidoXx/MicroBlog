package dzikiZAfryki.dao;

import dzikiZAfryki.model.Follower;

import java.util.List;

public interface FollowerDao {

    boolean addToFollweeList(int userId, int uidFollow);

    boolean removeFromFolloweeList(int userId, int uidFollow);

    boolean isOnFolloweeList(int userId, int uidFollow);

    List<Follower> showFolloweeList(int userId);


}


