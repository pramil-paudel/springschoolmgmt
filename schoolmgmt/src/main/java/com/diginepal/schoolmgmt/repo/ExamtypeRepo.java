package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Examtype;

@Repository
public interface ExamtypeRepo extends JpaRepository <Examtype, Integer> {

}
