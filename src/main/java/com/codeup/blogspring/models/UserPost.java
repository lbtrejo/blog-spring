package com.codeup.blogspring.models;

import javax.persistence.*;

@Entity
@Table(name = "user_posts")
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public UserPost(){}

    public UserPost(Post post){
        this.post = post;
    }

    public UserPost(long id, Post post){
        this.id = id;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
