package com.cts.sparemanagement_regestraion.service;

import com.cts.sparemanagement_regestraion.repository.UserRepository;
import com.cts.sparemanagement_regestraion.entity.UserDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public String userRegister(UserDetailsEntity detailsEntity) {
        log.info("Into the user register Service method ");
            String password = detailsEntity.getPassword();
            String encryptpwd = bCryptPasswordEncoder.encode(password);
            detailsEntity.setPassword(encryptpwd);
            detailsEntity.setRole("ROLE_"+detailsEntity.getRole());
            userRepository.save(detailsEntity);
            return "User successfully register";

    }


}
