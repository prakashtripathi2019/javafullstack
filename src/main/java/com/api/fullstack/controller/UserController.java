package com.api.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		repo.save(user);
		System.out.println("name"+user.getName());
		return "successfull registered";
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
		
	}
	
	@GetMapping("/getbyid/{id}")
	public User getAllUsersid(@PathVariable int id){
		  return  repo.findOne(id);	  
		
	}
	@DeleteMapping("/cancel/{id}")
	public List<User> getAllUsers(@PathVariable int id){
		  repo.delete(id);
	return (List<User>) repo.findAll();	  
		
	}
    
}
