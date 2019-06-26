package com.diginepal.schoolmgmt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diginepal.schoolmgmt.entities.Employee;
import com.diginepal.schoolmgmt.entities.Section;
import com.diginepal.schoolmgmt.entities.User;
import com.diginepal.schoolmgmt.repo.EmployeeRepo;
import com.diginepal.schoolmgmt.repo.UserRepo;
import com.diginepal.schoolmgmt.response.Response;
import com.diginepal.schoolmgmt.response.ResponseMessage;

@CrossOrigin("*")
@Controller
@RequestMapping("user")
public class UserRestController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired 
	private BCryptPasswordEncoder  passwordEncoder;
	
	@GetMapping(value="/new")
	public ModelAndView form() 
	{
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("employees", employeeRepo.findAll());
		return model;
	}
	
	@GetMapping
	public ModelAndView list() {
		return new ModelAndView("user/list");
	}
	
	@PostMapping 
	public ResponseEntity<?>save(@RequestBody User user) {
		ResponseMessage response= new ResponseMessage();
		String pwd=user.getPassword();
		String encryptPwd=passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		user=userRepo.save(user);
		if (user==null) {
			response=Response.badrequest();
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
		response=Response.created();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<?> findAll(){
		ResponseMessage response=new ResponseMessage();
		List<User> list=userRepo.findAll();
		if(list.isEmpty()) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@GetMapping (value="/{id}")
	public  ModelAndView findOne (@PathVariable int id){
		User user=userRepo.findById(id).get();
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("employees", employeeRepo.findAll());
		model.addObject(user);
		return model;
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody User user) {
		ResponseMessage response=new ResponseMessage();
		User search=userRepo.findById(id).get();
		if(search==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
			user.setId(id);
			user=userRepo.save(user);
			response=Response.successful();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		ResponseMessage response=new ResponseMessage();
		User user=userRepo.findById(id).get();
		if(user==null) {
			response=Response.resourcenotfound();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		else {
		userRepo.delete(user);
		response=Response.successful();
		return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
}
