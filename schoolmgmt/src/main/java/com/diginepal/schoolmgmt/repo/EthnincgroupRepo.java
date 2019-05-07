package com.diginepal.schoolmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Ethnicgroup;

@Repository
public interface EthnincgroupRepo extends JpaRepository<Ethnicgroup, Integer>{

}
