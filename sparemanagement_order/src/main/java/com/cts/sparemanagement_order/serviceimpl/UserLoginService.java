package com.cts.sparemanagement_order.serviceimpl;


import com.cts.sparemanagement_order.repository.UserRepository;
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
       CustomUserDetails customUserDetails = null;
        if(userRepository.findByUserName(userName)!=null){
            customUserDetails = new CustomUserDetails();
           customUserDetails.setUserDetailsEntity(userRepository.findByUserName(userName));
        }
        else {
            throw new UsernameNotFoundException("User not exist with name : " + userName);
        }
        return customUserDetails;    }
}
