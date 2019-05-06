package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Academicdates;

@Repository
public interface AcademicdatesRepo extends JpaRepository<Academicdates, Integer> {

}
