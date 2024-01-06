package com.instagram.clone.restApi.Controller;


import com.instagram.clone.restApi.exception.ResourceNotFoundException;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.ApiResponse;
import com.instagram.clone.restApi.repositories.UserRepo;
import com.instagram.clone.restApi.services.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inst/clone")
@AllArgsConstructor
public class FollowController {

    private FollowService followService;
    private UserRepo userRepo;


    @PostMapping("/follow/followerId/{followerId}")
    public ResponseEntity<ApiResponse> follow(@PathVariable Long followerId, @AuthenticationPrincipal User user) {
        this.followService.follow(user.getId(),followerId);
        return ResponseEntity.ok(new ApiResponse("Followed successfully", true));
    }

    @GetMapping("/followers/user/{userId}")
    public ResponseEntity<List<User>> getFollowers(@PathVariable Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        System.out.println(this.followService.getFollowers(user));
        return ResponseEntity.ok(this.followService.getFollowers(user));
    }

   @GetMapping("/followings/user/{userId}")
    public ResponseEntity<List<User>> getFollowings(@PathVariable Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
       System.out.println(this.followService.getFollowings(user));
        return ResponseEntity.ok(this.followService.getFollowings(user));
    }

    @DeleteMapping("/unfollow/followerId/{followerId}")
    public ResponseEntity<ApiResponse> unFollow(@PathVariable Long followerId, @AuthenticationPrincipal User user) {
        this.followService.unFollow(followerId, user.getId());
        return ResponseEntity.ok(new ApiResponse("Unfollowed successfully", true));
    }

    @GetMapping("/isFollowing/followerId/{followerId}")
    public ResponseEntity<Boolean> isFollowing(@PathVariable Long followerId, @AuthenticationPrincipal User user) {
        User follower = this.userRepo.findById(followerId).orElseThrow(() -> new ResourceNotFoundException("user", "id", followerId));
        return ResponseEntity.ok(this.followService.isFollowing(follower, user));
    }
}
