package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository <Employee, Integer> {

}
