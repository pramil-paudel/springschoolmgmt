package com.diginepal.schoolmgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diginepal.schoolmgmt.entities.Marks;
import com.diginepal.schoolmgmt.repo.MarksRepo;


@Component
@Transactional
public class MarksService {
	@Autowired MarksRepo marksRepo;
	
	
	public List<Marks> save(List<Marks> markslist){
		
		//set grade for each markslist
		List<Marks> list=new ArrayList<Marks>();
		list=marksRepo.saveAll(markslist);
		
		return list;
	}

}
