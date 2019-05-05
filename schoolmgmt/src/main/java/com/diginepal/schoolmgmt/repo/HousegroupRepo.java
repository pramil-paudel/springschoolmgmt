package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Housegroup;

@Repository
public interface HousegroupRepo extends JpaRepository <Housegroup, Integer> {

}
