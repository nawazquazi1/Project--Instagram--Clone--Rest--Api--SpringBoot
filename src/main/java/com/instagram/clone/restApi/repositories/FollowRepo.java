package com.instagram.clone.restApi.repositories;

import com.instagram.clone.restApi.model.Follow;
import com.instagram.clone.restApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepo extends JpaRepository<Follow, Long> {

    List<Follow> findByFollower(User user);

    List<Follow> findByFollowing(User user);

    Optional<Follow> findByFollowerAndFollowing(User follower, User following);

    boolean existsByFollowerAndFollowing(User follower, User following);
}
