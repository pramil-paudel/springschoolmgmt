package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Housegroup;
import com.diginepal.schoolmgmt.repo.HousegroupRepo;

@RestController
@RequestMapping("housegroup")
public class HousegroupController {

	@Autowired
	HousegroupRepo housegroupRepo;
	
	@PostMapping
	public Housegroup save(@RequestBody Housegroup housegroup) {
		return housegroupRepo.save(housegroup);
	}
	
	@GetMapping
	public List<Housegroup> findAll(){
		return housegroupRepo.findAll();
	}
}

