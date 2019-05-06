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

import com.diginepal.schoolmgmt.entities.Grade;
import com.diginepal.schoolmgmt.entities.Housegroup;
import com.diginepal.schoolmgmt.repo.HousegroupRepo;

@RestController
@RequestMapping("housegroup")
public class HousegroupController {

	@Autowired
	HousegroupRepo housegroupRepo;
	
	@PostMapping  (value="/save")
	public Housegroup save(@RequestBody Housegroup housegroup) {
		return housegroupRepo.save(housegroup);
	}
	
	@GetMapping (value="/list")
	public List<Housegroup> findAll(){
		return housegroupRepo.findAll();
	}
	@GetMapping (value="/{id}")
	public Housegroup findOne (@PathVariable int id){
		return housegroupRepo.findById(id).get();
	}
	
	@PutMapping(value="/update/{id}")
	public Housegroup update(@PathVariable int id,@RequestBody Housegroup housegroup) {
		housegroup.setId(id);
		return housegroupRepo.save(housegroup);

}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		Housegroup housegroup=housegroupRepo.findById(id).get();
		housegroupRepo.delete(housegroup);
	}
}

