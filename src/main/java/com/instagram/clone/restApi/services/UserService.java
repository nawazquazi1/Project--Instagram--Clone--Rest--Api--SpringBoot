package com.instagram.clone.restApi.services;

import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.UpdateUserDetails;
import com.instagram.clone.restApi.payloads.UserDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserService {
    UserDto registerUser(UserDto userDto);

    UserDto updateUser(UpdateUserDetails updateUserDetails, Long userId);

    List<UserDto> findAllUser();

    List<User> searchUsersByUsername(String username);

    UserDto findById(Long userId);


    UserDto setProfilePitcher(MultipartFile multipartFile,User user);

   void serveUserProfilePitcher(HttpServletResponse response,User user);

}
