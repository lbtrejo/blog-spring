package com.codeup.blogspring.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Post> posts;

    public User(){}

    public User(String username, String email, List<Post> posts){
        this.username = username;
        this.email = email;
        this.posts = posts;
    }

    public User(long id, String username, String email, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.posts = posts;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPosts(List<Post> posts){
        this.posts = posts;
    }

    public List<Post> getPosts(){
        return posts;
    }

}

