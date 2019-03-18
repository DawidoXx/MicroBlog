package dzikiZAfryki.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid", nullable = false)
    private Integer pid;

    @Column(name = "uid", nullable = false)
    private Integer uid;

    @Column(name = "datepost")
    private String datepost;

    @Column(name = "updateddate")
    private String updateddate;

    @Column(name = "descr", length = 255)
    private String descr;

    public Post(Integer uid, String descr) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String strDate = sdfDate.format(date);
        this.uid = uid;
        this.datepost = strDate;
        this.descr = descr;
        this.updateddate = this.datepost;
    }

    public Post() {

    }


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDatepost() {
        return datepost;
    }

    public void setDatepost(String datepost) {
        this.datepost = datepost;
    }

    public String getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(String updateddate) {
        this.updateddate = updateddate;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", datepost=" + datepost +
                ", descr='" + descr + '\'' +
                '}';
    }

}

