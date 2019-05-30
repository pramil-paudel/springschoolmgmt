package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Exam;

@Repository
public interface ExamRepo extends JpaRepository<Exam, Integer>{

}
