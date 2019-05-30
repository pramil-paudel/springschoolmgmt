package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Branch;

@Repository
public interface BranchRepo extends JpaRepository <Branch, Integer> {

}
