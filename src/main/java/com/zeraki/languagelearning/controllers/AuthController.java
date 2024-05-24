package com.zeraki.languagelearning.controllers;

import com.zeraki.languagelearning.dto.UserCreateDto;
import com.zeraki.languagelearning.dto.UserDto;
import com.zeraki.languagelearning.model.JWTRequest;
import com.zeraki.languagelearning.model.JWTResponse;
import com.zeraki.languagelearning.security.JwtHelper;
import com.zeraki.languagelearning.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
@Tag(name = "authentication")
@RestController
@RequestMapping(value = "/auth",name = "authentication")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserService userService;


    @Autowired
    private JwtHelper helper;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(AuthController.class);



    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {

        // this will get email and password from header.
        this.doAuthenticate(request.getEmail(), request.getPassword());


        // If all ok and validated by manager class then we get user here
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        // Generating tocken
        String token = this.helper.generateToken(userDetails);

        JWTResponse response = JWTResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> exceptionHandler() {
    return new ResponseEntity<>("Credentials Invalid !!", HttpStatus.UNAUTHORIZED);
    }


    // mapping for creating user
    @PostMapping("/create-user")
    public ResponseEntity<UserDto>createUser(@RequestBody UserCreateDto user){
        return  ResponseEntity.ok(userService.createUser(user));

    }

}
