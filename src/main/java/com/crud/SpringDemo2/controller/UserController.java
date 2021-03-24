package com.crud.SpringDemo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.SpringDemo2.dto.UserDTO;
import com.crud.SpringDemo2.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/list")
	public ResponseEntity<List<UserDTO>> getAllUsersList(){
		List<UserDTO> users = userServiceImpl.getAllUsers();
		System.out.println("Git changes to commit First time");
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId")Long userId){
		UserDTO userDTO = userServiceImpl.getUserById(userId);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable("userId")Long userId){
		userServiceImpl.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		UserDTO userSavedDTO = userServiceImpl.save(userDTO);
		return new ResponseEntity<>(userSavedDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("userId")Long userId, @RequestBody UserDTO userDTO){
		UserDTO userUpdatedDTO = userServiceImpl.save(userDTO);
		return new ResponseEntity<>(userUpdatedDTO, HttpStatus.OK);
	}
	
	
}
