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

import com.diginepal.schoolmgmt.entities.User;
import com.diginepal.schoolmgmt.repo.UserRepo;


@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping (value="/save")
	public User save(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping (value="/list")
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	@GetMapping (value="/{id}")
	public User findOne (@PathVariable int id){
		return userRepo.findById(id).get();
	}

	@PutMapping(value="/update/{id}")
	public User update(@PathVariable int id,@RequestBody User user) {
		user.setId(id);
		return userRepo.save(user);
}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		User user=userRepo.findById(id).get();
		userRepo.delete(user);
	}

}
