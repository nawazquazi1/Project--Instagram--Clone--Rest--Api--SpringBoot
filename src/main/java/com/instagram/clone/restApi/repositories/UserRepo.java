package com.instagram.clone.restApi.repositories;

import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);

    Optional<UserDto> findByEmail(String email);

    List<User> findByUsernameOrUsernameStartsWith(String username, String usernameStartWith);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
