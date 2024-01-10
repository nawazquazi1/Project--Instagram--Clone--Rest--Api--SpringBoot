package com.instagram.clone.restApi.Controller;

import com.instagram.clone.restApi.exception.ApiException;
import com.instagram.clone.restApi.exception.EmailAlreadyExistsException;
import com.instagram.clone.restApi.exception.UsernameAlreadyExistsException;
import com.instagram.clone.restApi.model.User;
import com.instagram.clone.restApi.payloads.JwtAuthResponse;
import com.instagram.clone.restApi.payloads.LoginRequest;
import com.instagram.clone.restApi.payloads.UserDto;
import com.instagram.clone.restApi.repositories.UserRepo;
import com.instagram.clone.restApi.security.JwtTokenHelper;
import com.instagram.clone.restApi.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiVisibility;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Api(name = "Instagram Clone Rest Api",description = "User Authentication",group = "user",visibility = ApiVisibility.PUBLIC)
public class AuthController {

    private final UserService userService;
    private final JwtTokenHelper jwtTokenHelper;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;
    private UserRepo userRepo;

    @PostMapping("/register")
    @ApiMethod(description = "Add new user")
    public ResponseEntity<JwtAuthResponse> registerUser(@Valid @RequestBody UserDto user) {
        UserDto user1;
        try {
            user1 = userService.registerUser(user);
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            throw new ApiException(e.getMessage());
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(user1.getUsername());
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(this.jwtTokenHelper.generateToken(userDetails), user1);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("/login")
    @ApiMethod(description = "Authenticate User")
    public ResponseEntity<JwtAuthResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            System.out.println(loginRequest.getUsername() + loginRequest.getPassword());
            this.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getUsername());
        User user = this.userRepo.findByUsername(userDetails.getUsername()).orElseThrow();
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(this.jwtTokenHelper.generateToken(userDetails), this.modelMapper.map(user, UserDto.class));
        return ResponseEntity.ok(jwtAuthResponse);
    }

    private void authenticate(String username, String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Details !!");
            throw new ApiException("Invalid username or password !!");
        }
    }


}
