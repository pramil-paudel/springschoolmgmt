package com.diginepal.schoolmgmt.auth.repository;


import com.diginepal.schoolmgmt.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String emailAddress);
}
