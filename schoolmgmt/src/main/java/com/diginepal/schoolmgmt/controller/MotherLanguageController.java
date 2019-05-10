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

import com.diginepal.schoolmgmt.entities.MotherLanguage;
import com.diginepal.schoolmgmt.repo.MotherLanguageRepo;

@Controller
@RequestMapping("motherlanguage")
public class MotherLanguageController {
	@Autowired
	MotherLanguageRepo motherLanguageRepo;

	@PostMapping(value = "/save")
	public MotherLanguage save(@RequestBody MotherLanguage motherLanguage) {
		return motherLanguageRepo.save(motherLanguage);
	}

	@GetMapping(value="/list")
	public String findAll(Model model){
		List<MotherLanguage> list=motherLanguageRepo.findAll();
		model.addAttribute("motherLangauge", list);
		return "motherlanguage/list";
	}
	@GetMapping(value = "/{id}")
	public MotherLanguage findOne(@PathVariable int id) {
		return motherLanguageRepo.findById(id).get();
	}
	
	@PutMapping(value="/update/{id}")
	public MotherLanguage update(@PathVariable int id,@RequestBody MotherLanguage motherlanguage) {
		motherlanguage.setId(id);
		return motherLanguageRepo.save(motherlanguage);
	}
	

	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		MotherLanguage motherlanguage=motherLanguageRepo.findById(id).get();
		motherLanguageRepo.delete(motherlanguage);
	}
}