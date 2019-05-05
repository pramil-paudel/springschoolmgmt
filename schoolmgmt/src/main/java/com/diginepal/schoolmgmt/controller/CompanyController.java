package com.diginepal.schoolmgmt.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Company;
import com.diginepal.schoolmgmt.repo.CompanyRepo;

@RestController
@RequestMapping("company")
public class CompanyController {
	@Autowired
	CompanyRepo companyRepo;
	
	@PostMapping
	public Company save(@RequestBody Company company) {
		return companyRepo.save(company);
	}
	
	@GetMapping
	public List<Company> findAll(){
		return companyRepo.findAll();
	}
}
