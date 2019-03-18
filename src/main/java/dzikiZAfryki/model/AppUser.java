package dzikiZAfryki.model;

import javax.persistence.*;

@Entity
@Table(name = "AppUser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int uid;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AppUser(String username, String password, String email, String name, String surname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public AppUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public AppUser() {

    }

    public boolean compaare(AppUser appUser) {
        return this.email == appUser.getEmail() && this.name == appUser.getName() && this.password == appUser.getPassword() && this.surname == appUser.getSurname() && this.username == appUser.getUsername();
    }


}
