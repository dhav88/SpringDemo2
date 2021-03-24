package com.crud.SpringDemo2.helper;

import org.springframework.stereotype.Component;

import com.crud.SpringDemo2.dto.UserDTO;
import com.crud.SpringDemo2.model.User;

@Component
public class UserHelper {

	public UserDTO modelToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUserName(user.getUserName());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}
	
	public User DTOToModel(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setUserName(userDTO.getUserName());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		return user;
	}
}
