package com.cts.sparemanagement_regestraion.controller;

import com.cts.sparemanagement_regestraion.entity.UserDetailsEntity;
import com.cts.sparemanagement_regestraion.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @GetMapping("/location")
    public String getRegesterServiceLocation(){

        log.info("Into the location controller");
        return appName + " : " + port;
    }

    @PostMapping("/user/signup")
    public ResponseEntity<String> resgesterUser(@Valid @RequestBody UserDetailsEntity userDetailsEntity){
        log.info("Into the regester user Controller");
        return new ResponseEntity<>(userService.userRegister(userDetailsEntity), HttpStatus.CREATED);
    }

    @GetMapping("/user/login")
    public  ResponseEntity<String> loginUser(){
        return new ResponseEntity<>("User Login Successfully ", HttpStatus.OK);
    }

    @GetMapping("/logout")
    public void logout(final HttpSecurity httpSecurity) throws Exception{
        httpSecurity.logout().invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }
}
