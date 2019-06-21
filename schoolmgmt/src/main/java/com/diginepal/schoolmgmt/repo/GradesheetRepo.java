package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diginepal.schoolmgmt.entities.Gradesheet;

public interface GradesheetRepo extends JpaRepository <Gradesheet, Integer> {

}
