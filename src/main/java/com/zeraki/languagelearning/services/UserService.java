package com.zeraki.languagelearning.services;

import com.zeraki.languagelearning.Repositories.UserRepository;
import com.zeraki.languagelearning.dto.UserCreateDto;
import com.zeraki.languagelearning.dto.UserDto;
import com.zeraki.languagelearning.entities.User;
import com.zeraki.languagelearning.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
 
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    // Fetch user by email
    public List<User> getUsers(){
       // return this.store;      // this is for in memory data 
       return this.userRepository.findAll();
    }

    // Create User
    public UserDto createUser(UserCreateDto user){
        User productCategory = userMapper.userCreateDTOToUser(user);
        productCategory.setDateCreated(new Timestamp(new Date().getTime()));
        productCategory.setPassword(passwordEncoder.encode(user.getPassword()));
        productCategory = userRepository.save(productCategory);
        return userMapper.toDto(productCategory);
    }
    
    
}
