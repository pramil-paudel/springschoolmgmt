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

import com.diginepal.schoolmgmt.entities.Employee;
import com.diginepal.schoolmgmt.repo.EmployeeRepo;

@RestController
@RequestMapping("employee")

public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping (value="/save")
	public Employee save(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@GetMapping (value="/list")
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
	
	@GetMapping (value="/{id}")
	public Employee findOne (@PathVariable int id){
		return employeeRepo.findById(id).get();
	}

	@PutMapping(value="/update/{id}")
	public Employee update(@PathVariable int id,@RequestBody Employee employee) {
		employee.setId(id);
		return employeeRepo.save(employee);
}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		Employee employee=employeeRepo.findById(id).get();
		employeeRepo.delete(employee);
	}


}
