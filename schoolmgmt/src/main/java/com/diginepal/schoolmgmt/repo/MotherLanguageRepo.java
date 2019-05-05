package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.MotherLanguage;

@Repository
public interface MotherLanguageRepo extends JpaRepository <MotherLanguage, Integer>{

}
