package com.instagram.clone.restApi.services;

import com.instagram.clone.restApi.model.Post;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.PostRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PostService {
    void createPost(PostRequest postRequest, User user);

    Post uploadPost(MultipartFile multipartFile, Long postId);

    boolean deletePost(Long postId, User user);

    List<Post> getAllUserPost(User user);

    Post findById(Long postId);

    List<Post> findByUserId(Long uerId);

    void servePostImages(HttpServletResponse response, Long postId);

    void serveUserPostImages(HttpServletResponse response, Long userId);

    void serveUserPostImages(HttpServletResponse response, User user);


}
