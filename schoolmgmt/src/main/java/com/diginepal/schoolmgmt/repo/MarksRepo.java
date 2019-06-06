package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Marks;

@Repository
public interface MarksRepo extends JpaRepository <Marks, Integer> {

}
 