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

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<UserPost> posts;

    public User(){}

    public User(String username, String email, String password, List<UserPost> posts){
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public User(long id, String username, String email, String password, List<UserPost> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPosts(List<UserPost> posts){
        this.posts = posts;
    }

    public List<UserPost> getPosts(){
        return posts;
    }

}

