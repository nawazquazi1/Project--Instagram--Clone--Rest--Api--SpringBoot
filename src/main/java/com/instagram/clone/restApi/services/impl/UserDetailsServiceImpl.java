package com.instagram.clone.restApi.services.impl;

import com.instagram.clone.restApi.exception.ResourceNotFoundException;
import com.instagram.clone.restApi.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "userName", username));
    }
}