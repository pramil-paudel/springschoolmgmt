package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.DigiUser;

@Repository
public interface UserRepo extends JpaRepository <DigiUser, Integer>{

}
