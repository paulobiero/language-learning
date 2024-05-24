package com.zeraki.languagelearning.services;


import com.zeraki.languagelearning.Repositories.UserRepository;
import com.zeraki.languagelearning.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        // Load user by username from database

        User user = userRepository.findByEmail(username)
        // if useename not avalble it will throws error 
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found !!!"));
        return user;
    }
    
}
