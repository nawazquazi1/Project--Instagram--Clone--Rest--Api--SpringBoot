package com.instagram.clone.restApi.services.impl;

import com.instagram.clone.restApi.exception.NotAllowedException;
import com.instagram.clone.restApi.exception.ResourceNotFoundException;
import com.instagram.clone.restApi.model.Comment;
import com.instagram.clone.restApi.model.Post;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.CommentRequest;
import com.instagram.clone.restApi.repositories.CommentRepo;
import com.instagram.clone.restApi.repositories.UserRepo;
import com.instagram.clone.restApi.services.CommentService;
import com.instagram.clone.restApi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {


    private CommentRepo commentRepo;
    private UserRepo userRepo;
    private PostService postService;

    @Override
    public Comment addComment(CommentRequest commentRequest, Long postId, Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        Post post = this.postService.findById(postId);
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setPost(post);
        comment.setUser(user);
        comment.setCreatedAt(Instant.now());
        comment = this.commentRepo.save(comment);
        return comment;
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return this.commentRepo.findByPostId(postId);
    }

    @Override
    public void deleteComment(Long commentId, Long userId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
        if (!comment.getUser().equals(user)) {
            throw new NotAllowedException("" + userId, "delete", "comment");
        }
        this.commentRepo.delete(comment);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
    }
}
