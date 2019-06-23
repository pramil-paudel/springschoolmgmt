package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diginepal.schoolmgmt.entities.Gradesheet;

public interface GradesheetRepo extends JpaRepository <Gradesheet, Integer> {
@Query("SELECT g FROM Gradesheet g WHERE ?1 BETWEEN g.low AND g.high")
public Gradesheet findGradeByMarks( Double marks);
}
