package com.api.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.fullstack.dao.UserRepo;
import com.api.fullstack.model.User;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		repo.save(user);
		return "successfull registered";
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
		
	}
	
	@DeleteMapping("/cancel/{id}")
	public List<User> getAllUsers(@PathVariable int id){
		  repo.delete(id);
	return (List<User>) repo.findAll();	  
		
	}
    
}
