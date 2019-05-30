package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Generaldetails;

@Repository
public interface GeneraldetailsRepo extends JpaRepository<Generaldetails, Integer>{

}
