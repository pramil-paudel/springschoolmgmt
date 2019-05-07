package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Branch;
import com.diginepal.schoolmgmt.repo.BranchRepo;


@RestController
@RequestMapping("branch")

public class BranchController {
		
		@Autowired
		BranchRepo branchRepo;
		
		@PostMapping (value="/save")
		public Branch save(@RequestBody Branch branch) {
			return branchRepo.save(branch);
		}
		
		@GetMapping (value="/list")
		public List<Branch> findAll(){
			return branchRepo.findAll();
		}
		
		@GetMapping (value="/{id}")
		public Branch findOne (@PathVariable int id){
			return branchRepo.findById(id).get();
		}

		@PutMapping(value="/update/{id}")
		public Branch update(@PathVariable int id,@RequestBody Branch branch) {
			branch.setId(id);
			return branchRepo.save(branch);
	}
		@DeleteMapping(value="/delete/{id}")
		public void delete(@PathVariable int id) {
			Branch branch=branchRepo.findById(id).get();
			branchRepo.delete(branch);
		}

	}


