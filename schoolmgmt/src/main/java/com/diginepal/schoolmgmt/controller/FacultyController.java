package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diginepal.schoolmgmt.entities.Faculty;
import com.diginepal.schoolmgmt.repo.FacultyRepo;

@Controller
@RequestMapping("faculty")
public class FacultyController {

@Autowired
FacultyRepo facultyRepo;

@PostMapping (value="/save")
public Faculty save(@RequestBody Faculty faculty) {
	return facultyRepo.save(faculty);
	
}

@GetMapping(value="/list")
public String findAll(Model model){
	List<Faculty> list=facultyRepo.findAll();
	model.addAttribute("faculty", list);
	return "faculty/list";
}

@GetMapping (value="/{id}")
public Faculty findOne (@PathVariable int id){
	return facultyRepo.findById(id).get();
}

@PutMapping(value="/update/{id}")
public Faculty update(@PathVariable int id,@RequestBody Faculty faculty) {
	faculty.setId(id);
	return facultyRepo.save(faculty);
}
@DeleteMapping(value="/delete/{id}")
public void delete(@PathVariable int id) {
	Faculty faculty=facultyRepo.findById(id).get();
	facultyRepo.delete(faculty);
}

}
