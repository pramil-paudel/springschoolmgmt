package com.diginepal.schoolmgmt.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diginepal.schoolmgmt.entities.Academicdates;
import com.diginepal.schoolmgmt.entities.Branch;
import com.diginepal.schoolmgmt.entities.Company;
import com.diginepal.schoolmgmt.repo.CompanyRepo;

@Controller
@RequestMapping("company")
public class CompanyController {
	@Autowired
	CompanyRepo companyRepo;
	
	@PostMapping(value="/save")
	public Company save(@RequestBody Company company) {
		return companyRepo.save(company);
	}
	
	@GetMapping(value="/list")
	public String findAll(Model model){
		List<Company> list=companyRepo.findAll();
		model.addAttribute("company", list);
		return "company/list";
	}
	
	@GetMapping(value="/{id}")
	public Company findOne(@PathVariable int id){
		System.out.println(id);
		return companyRepo.findById(id).get();
	}
	
	@PutMapping(value="/update/{id}")
	public Company update(@PathVariable int id,@RequestBody Company company) {
		company.setId(id);
		return companyRepo.save(company);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		Company company=companyRepo.findById(id).get();
		companyRepo.delete(company);
}
}
