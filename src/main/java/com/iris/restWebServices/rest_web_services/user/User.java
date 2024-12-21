package com.iris.restWebServices.rest_web_services.user;

import com.iris.restWebServices.rest_web_services.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.security.PrivateKey;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue
    private Integer id;


    @Size(min = 2, message = "name should be of mininmum 2 chars")
    private String username;

    @Past
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;



    public User() {}

    public User(String username, int id, Date birthDate) {
        this.username = username;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }
}
