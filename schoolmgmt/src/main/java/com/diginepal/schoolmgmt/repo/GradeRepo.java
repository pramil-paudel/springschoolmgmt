package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Grade;

@Repository
public interface GradeRepo extends JpaRepository <Grade, Integer> {


}
