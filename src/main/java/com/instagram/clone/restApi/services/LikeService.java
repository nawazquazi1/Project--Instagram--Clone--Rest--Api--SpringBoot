package com.instagram.clone.restApi.services;

import com.instagram.clone.restApi.model.Likes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {
    Likes doLike(Long userId, Long postId);

    void unLike(Long userId,Long postId);

    List<Likes> getPostLikes(Long postId);

}
