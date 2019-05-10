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

import com.diginepal.schoolmgmt.entities.Ethnicgroup;
import com.diginepal.schoolmgmt.repo.EthnincgroupRepo;

@Controller
@RequestMapping("ethnicgroup")
public class EthnicgroupController {
	@Autowired
	EthnincgroupRepo ethnicgroupRepo;

	@PostMapping(value = "/save")
	public Ethnicgroup save(@RequestBody Ethnicgroup ethnicgroup) {
		return ethnicgroupRepo.save(ethnicgroup);
	}

	@GetMapping(value="/list")
	public String findAll(Model model){
		List<Ethnicgroup> list=ethnicgroupRepo.findAll();
		model.addAttribute("ethnicgroup", list);
		return "ethnicgroup/list";
	}

	@GetMapping(value = "/{id}")
	public Ethnicgroup findOne(@PathVariable int id) {
		return ethnicgroupRepo.findById(id).get();
	}

	@PutMapping(value = "/update/{id}")
	public Ethnicgroup update(@PathVariable int id, @RequestBody Ethnicgroup ethnicgroup) {
		ethnicgroup.setId(id);
		return ethnicgroupRepo.save(ethnicgroup);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable int id) {
		Ethnicgroup ethnicgroup = ethnicgroupRepo.findById(id).get();
		ethnicgroupRepo.delete(ethnicgroup);
	}

}
