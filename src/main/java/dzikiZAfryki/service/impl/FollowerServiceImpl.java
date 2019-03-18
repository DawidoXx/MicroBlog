package dzikiZAfryki.service.impl;

import dzikiZAfryki.dao.FollowerDao;
import dzikiZAfryki.model.Follower;
import dzikiZAfryki.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private FollowerDao followerDao;

    @Override
    public boolean addToFollweeList(int userId, int uidFollow) {
        return followerDao.addToFollweeList(userId, uidFollow);
    }

    @Override
    public boolean removeFromFolloweeList(int userId, int uidFollow) {
        return followerDao.removeFromFolloweeList(userId, uidFollow);
    }

    @Override
    public boolean isOnFolloweeList(int userId, int uidFollow) {
        return followerDao.isOnFolloweeList(userId, uidFollow);
    }

    @Override
    public List<Follower> showFolloweeList(int userId) {
        return followerDao.showFolloweeList(userId);
    }
}
