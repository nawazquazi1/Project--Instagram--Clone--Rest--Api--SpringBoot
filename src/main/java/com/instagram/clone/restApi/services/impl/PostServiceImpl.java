package com.instagram.clone.restApi.services.impl;


import com.instagram.clone.restApi.exception.NotAllowedException;
import com.instagram.clone.restApi.exception.ResourceNotFoundException;
import com.instagram.clone.restApi.model.Post;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.PostRequest;
import com.instagram.clone.restApi.repositories.PostRepo;
import com.instagram.clone.restApi.services.FileService;
import com.instagram.clone.restApi.services.PostService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final FileService fileService;

    @Override
    public void createPost(PostRequest postRequest, User user) {
        log.info("creating post image url {}", postRequest.getImageUrl());
        Post post = new Post();
        post.setImageUrl(postRequest.getImageUrl());
        post.setCaption(postRequest.getCaption());
        post.setCreatedAt(Instant.now());
        post.setUser(user);
        post = this.postRepo.save(post);
        log.info("post {} is saved successfully for user {}", post.getId(), post.getUser());
    }

    @Override
    public Post uploadPost(MultipartFile multipartFile, Long postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        String postImageName = this.fileService.uploadImage("image/post/", multipartFile);
        post.setImageUrl(postImageName);
        post.setUpdatedAt(Instant.now());
        return this.postRepo.save(post);
    }

    @Override
    public boolean deletePost(Long postId, User user) {
        log.info("deleting post {}", postId);
        Post post = this.findById(postId);
        if (!post.getUser().getId().equals(user.getId())) {
            throw new NotAllowedException("" + user, "post id" + postId, "delete");
        } else {
            log.info("Deleting image with URL: {}", post.getImageUrl());
            this.fileService.deleteProfilePicture(post.getImageUrl(), "image/post/");

            log.info("Deleting post from the database");
            this.postRepo.delete(post);

            log.info("Post deleted successfully");
            return true;
        }
    }

    @Override
    public List<Post> getAllUserPost(User user) {
        return this.postRepo.findByUserOrderByCreatedAtDesc(user);
    }

    @Override
    public Post findById(Long id) {
        return this
                .postRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", id));

    }

    @Override
    public List<Post> findByUserId(Long uerId) {
        return this.postRepo.findByUserId(uerId);
    }

    @Override
    public void servePostImages(HttpServletResponse response, Long postId) {
        try {
            Post post = this.findById(postId);
            InputStream resource = this.fileService.getResource("image/post/", post.getImageUrl());
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(resource, response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void serveUserPostImages(HttpServletResponse response, Long userId) {
        try {
            List<Post> posts = this.findByUserId(userId);
            for (Post post : posts) {
                InputStream resource = this.fileService.getResource("image/post/", post.getImageUrl());
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                StreamUtils.copy(resource, response.getOutputStream());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void serveUserPostImages(HttpServletResponse response, User user) {
        try {
            List<Post> posts = this.getAllUserPost(user);
            System.out.println(posts);
            for (Post post : posts) {
                InputStream resource = this.fileService.getResource("image/post/", post.getImageUrl());
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                StreamUtils.copy(resource, response.getOutputStream());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
