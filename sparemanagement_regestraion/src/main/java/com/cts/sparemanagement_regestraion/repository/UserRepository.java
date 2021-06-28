package com.cts.sparemanagement_regestraion.repository;

import com.cts.sparemanagement_regestraion.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsEntity , Integer> {

    public UserDetailsEntity findByUserName(String userName);
}
