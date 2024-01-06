package com.instagram.clone.restApi.repositories;

import com.instagram.clone.restApi.model.Likes;
import com.instagram.clone.restApi.model.Post;
import com.instagram.clone.restApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepo extends JpaRepository<Likes, Long> {
    Likes findByUserAndPost(User userId, Post postId);

    Optional<List<Likes>> findByPostId(Long postId);
}
