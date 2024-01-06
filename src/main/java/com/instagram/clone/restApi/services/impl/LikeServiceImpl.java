package com.instagram.clone.restApi.services.impl;


import com.instagram.clone.restApi.exception.ResourceNotFoundException;
import com.instagram.clone.restApi.model.Likes;
import com.instagram.clone.restApi.model.Post;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.repositories.LikeRepo;
import com.instagram.clone.restApi.repositories.UserRepo;
import com.instagram.clone.restApi.services.LikeService;
import com.instagram.clone.restApi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepo likeRepo;
    private final UserRepo userRepo;
    private final PostService postService;

    @Override
    public Likes doLike(Long userId, Long postId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        Post post = this.postService.findById(postId);

        Likes like = this.likeRepo.findByUserAndPost(user, post);
        System.out.println(like);
        if (like != null) {
            return like;
        }
        Likes likes = new Likes();
        likes.setUser(user);
        likes.setPost(post);
        likes.setCreateAt(Instant.now());
        System.out.println(likes);
        return this.likeRepo.save(likes);
    }

    @Override
    public void unLike(Long userId, Long postId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        Post post = this.postService.findById(postId);
        Likes like = this.likeRepo.findByUserAndPost(user, post);
        if (like != null) {
            this.likeRepo.delete(like);
        }
    }

    @Override
    public List<Likes> getPostLikes(Long postId) {
        return this.likeRepo.findByPostId(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
    }
}
