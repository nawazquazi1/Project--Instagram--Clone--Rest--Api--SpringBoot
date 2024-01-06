package com.instagram.clone.restApi.repositories;

import com.instagram.clone.restApi.model.Post;
import com.instagram.clone.restApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    //    @Query("SELECT p FROM Post p WHERE p.user = :user ORDER BY p.createdAt DESC")
    List<Post> findByUserOrderByCreatedAtDesc(User user);

    List<Post> findByIdInOrderByCreatedAtDesc(Collection<Long> id);

    List<Post> findByUserId(Long userId);

}
