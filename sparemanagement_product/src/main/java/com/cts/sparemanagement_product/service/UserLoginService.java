package com.cts.sparemanagement_product.service;



import com.cts.sparemanagement_product.entity.UserDetailsEntity;
import com.cts.sparemanagement_product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetailsEntity userDetailsEntity = userRepository.findByUserName(userName);
       CustomUserDetails customUserDetails = null;
        if(userDetailsEntity!=null){
            customUserDetails = new CustomUserDetails();
           customUserDetails.setUserDetailsEntity(userDetailsEntity);
        }
        else {
            throw new UsernameNotFoundException("User not exist with name : " + userName);
        }
        return customUserDetails;
    }
}
