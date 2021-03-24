package com.crud.SpringDemo2.service;

import java.util.List;

import com.crud.SpringDemo2.dto.UserDTO;

public interface UserService {

	public List<UserDTO> getAllUsers();
	
	public UserDTO getUserById(Long userId);
	
	public void deleteUserById(Long userId);
	
	public UserDTO save(UserDTO userDTO);
	
}
