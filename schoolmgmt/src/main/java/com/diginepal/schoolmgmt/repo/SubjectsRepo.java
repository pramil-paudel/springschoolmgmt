package com.diginepal.schoolmgmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diginepal.schoolmgmt.entities.Subjects;

@Repository
public interface SubjectsRepo extends JpaRepository <Subjects, Integer> {
	public List<Subjects> findByStudentsId(int studentid);

	
}
