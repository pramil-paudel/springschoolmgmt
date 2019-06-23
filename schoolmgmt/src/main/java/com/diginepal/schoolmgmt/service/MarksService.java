package com.diginepal.schoolmgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diginepal.schoolmgmt.entities.Gradesheet;
import com.diginepal.schoolmgmt.entities.Marks;
import com.diginepal.schoolmgmt.entities.Subjects;
import com.diginepal.schoolmgmt.repo.GradesheetRepo;
import com.diginepal.schoolmgmt.repo.MarksRepo;
import com.diginepal.schoolmgmt.repo.SubjectsRepo;


@Component
@Transactional
public class MarksService {
	@Autowired MarksRepo marksRepo;
	
	@Autowired GradesheetRepo gradesheetRepo;
	
	@Autowired SubjectsRepo subjectsRepo;
	
	
	public List<Marks> save(List<Marks> markslist){
		Gradesheet gradesheet=null;
		Subjects subjects=null;
		
		for(Marks marks:markslist) {
			gradesheet=new Gradesheet();
			Double obt_total=marks.getPrmarks()+marks.getThmarks();
			
			subjects=subjectsRepo.findById(marks.getSubjects().getId()).get();
			Double subject_total=subjects.getFullmarks_pr()+subjects.getFullmarks_th();
			Double percentage_total=(obt_total/subject_total)*100;
			gradesheet=gradesheetRepo.findGradeByMarks(percentage_total);
			marks.setGradesheet(gradesheet);
		}
		
		List<Marks> list=new ArrayList<Marks>();
		list=marksRepo.saveAll(markslist);
		
		return list;
	}

}
