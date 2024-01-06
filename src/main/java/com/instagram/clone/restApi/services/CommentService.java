package com.instagram.clone.restApi.services;

import com.instagram.clone.restApi.model.Comment;
import com.instagram.clone.restApi.payloads.CommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment addComment(CommentRequest commentRequest, Long postId, Long userId);
    List<Comment> getCommentsByPostId(Long postId);

    void deleteComment(Long commentId, Long userId);

    Comment getCommentById(Long commentId);

}
