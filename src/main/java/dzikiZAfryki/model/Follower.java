package dzikiZAfryki.model;

import javax.persistence.*;

@Entity
@Table(name = "Follower")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuid")
    private int followerId;

    @Column(name = "uid", nullable = false)
    private int userId;

    @Column(name = "uid_followuje", nullable = false)
    private int uidFollow;

    public Follower(int userId, int uidFollow) {
        this.userId = userId;
        this.uidFollow = uidFollow;
    }

    public Follower() {

    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getUidFollow() {
        return uidFollow;
    }

    public void setUidFollow(int uidFollow) {
        this.uidFollow = uidFollow;
    }

    public int getFollowerId() {
        return followerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "followerId=" + followerId +
                ", userId=" + userId +
                ", uidFollow=" + uidFollow +
                '}';
    }
}
