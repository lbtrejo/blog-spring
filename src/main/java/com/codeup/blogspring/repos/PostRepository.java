package com.codeup.blogspring.repos;

import com.codeup.blogspring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("from Post p where p.title OR p.body like %:term%")
    List<Post> findAllByTitleOrBody(@Param("term") String term);
}
