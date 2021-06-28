package com.cts.sparemanagement_order.repository;

import com.cts.sparemanagement_order.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsEntity , String> {

    public UserDetailsEntity findByUserName(String userName);

}
