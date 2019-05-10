package com.diginepal.schoolmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.diginepal.schoolmgmt.entities.MotherLanguage;
import com.diginepal.schoolmgmt.entities.Section;
import com.diginepal.schoolmgmt.repo.SectionRepo;

public class SectionController {
	
	@Autowired
	SectionRepo sectionRepo;
	
	@PostMapping (value="/save")
	public Section save(@RequestBody Section section) {
		return sectionRepo.save(section);
	}
	
	@GetMapping(value="/list")
	public String findAll(Model model){
		List<Section> list=sectionRepo.findAll();
		model.addAttribute("section", list);
		return "section/list";
	}
	
	@GetMapping (value="/{id}")
	public Section findOne (@PathVariable int id){
		return sectionRepo.findById(id).get();
	}

	@PutMapping(value="/update/{id}")
	public Section update(@PathVariable int id,@RequestBody Section section) {
		section.setId(id);
		return sectionRepo.save(section);
}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		Section section=sectionRepo.findById(id).get();
		sectionRepo.delete(section);
	}

}
