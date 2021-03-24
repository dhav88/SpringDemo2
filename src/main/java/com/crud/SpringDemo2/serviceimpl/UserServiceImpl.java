package com.crud.SpringDemo2.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.SpringDemo2.dto.UserDTO;
import com.crud.SpringDemo2.helper.UserHelper;
import com.crud.SpringDemo2.model.User;
import com.crud.SpringDemo2.repository.UserRepository;
import com.crud.SpringDemo2.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserHelper userHelper;

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOS = new ArrayList<>();
		for(User user : users) {
			userDTOS.add(userHelper.modelToDTO(user));
		}
		return userDTOS;
	}

	@Override
	public UserDTO getUserById(Long userId) {

		User user = userRepository.getOne(userId);
		UserDTO userDTO = userHelper.modelToDTO(user);
		return userDTO;
	}

	@Override
	public void deleteUserById(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = userHelper.DTOToModel(userDTO);
		User userSaved = userRepository.saveAndFlush(user);
		UserDTO userSavedDTO = userHelper.modelToDTO(userSaved);
		return userSavedDTO;
	}

}
