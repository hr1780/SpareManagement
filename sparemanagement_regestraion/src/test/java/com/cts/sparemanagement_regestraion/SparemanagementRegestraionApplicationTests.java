package com.cts.sparemanagement_regestraion;

import com.cts.sparemanagement_regestraion.repository.UserRepository;
import com.cts.sparemanagement_regestraion.entity.UserDetailsEntity;
import com.cts.sparemanagement_regestraion.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;


import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


@SpringBootTest
class SparemanagementRegestraionApplicationTests {

	@MockBean
    UserRepository userRepository;

	@Autowired
	UserService userService;

	public UserDetailsEntity mockUserDetailEntity(){

		UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
		userDetailsEntity.setUserName("HR431");
		userDetailsEntity.setPassword("password");
		userDetailsEntity.setAddress("Patna");
		userDetailsEntity.setContactNo("9304271835");
		userDetailsEntity.setCountry("India");
		userDetailsEntity.setState("Bihar");
		userDetailsEntity.setDateOfBirth(new Date(1997-07-25));
		userDetailsEntity.setRole("ADMIN");

		return userDetailsEntity;
	}



	@Test
	 void mockUserRegester(){
		when(userRepository.save(mockUserDetailEntity())).thenReturn(mockUserDetailEntity());
		assertEquals("User successfully register",userService.userRegister(mockUserDetailEntity()));

	}

}
