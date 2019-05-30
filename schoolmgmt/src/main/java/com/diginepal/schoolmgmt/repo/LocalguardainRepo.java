package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.LocalGuardian;

@Repository
public interface LocalguardainRepo extends JpaRepository <LocalGuardian, Integer> {

}
