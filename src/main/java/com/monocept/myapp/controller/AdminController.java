package com.monocept.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.myapp.entity.Employer;
import com.monocept.myapp.entity.User;
import com.monocept.myapp.service.JobService;

@RestController
@RequestMapping("api/admin")
public class AdminController {
	
	@Autowired
	private JobService jobService;
	
	@PostMapping("/registerEmployee")
	public ResponseEntity<Employer> createEmployee(@RequestBody Employer employer,@PathVariable(name="userId") long userId) {
		return new ResponseEntity<Employer>(jobService.createEmployee(employer,userId),
				HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(jobService.createUser(user),HttpStatus.ACCEPTED);
	}

}
