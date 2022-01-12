package com.webcrudsecurityboot.webcrudsecurityboot.service;

import com.webcrudsecurityboot.webcrudsecurityboot.model.User;
import com.webcrudsecurityboot.webcrudsecurityboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByName(email);
        if(user == null) {
            throw new UsernameNotFoundException("User with email:" + email + "not found!");
        }
        return user;
    }
}
