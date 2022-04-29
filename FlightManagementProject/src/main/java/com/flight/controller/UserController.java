package com.flight.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.flight.entities.Users;
import com.flight.exceptions.ValueNotFoundException;
import com.flight.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@GetMapping("/user")
	public List<Users>  getusers(){
		return this.userservice.getUsers();
	}
	@PostMapping("/user")
	public Users addUser(@RequestBody Users user) {
		return this.userservice.addUser(user) ;
	}
	@PutMapping("user")
	public Users UpdateUser(@RequestBody Users user) {
		return this.userservice.updateUser(user) ;
	}
	@GetMapping("/users/{usersid}")
	public ResponseEntity getUserById(@PathVariable("usersid") int id){
		return new ResponseEntity(userservice.getUserById(id), HttpStatus.OK);
	}
	@GetMapping("/relateduser")
	public List<Users> GetRelatedUser(){
		return this.userservice.GetRelatedUser();
	}
	@GetMapping("/kname")
	public List<Users> GetUserName(){
		return this.userservice.GetUserName();
	}
	@PostMapping("/users")
	public ResponseEntity addUsers(@RequestBody Users users)throws ValueNotFoundException {
		Users u =  userservice.addUser(users);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
		
		
	}

}
