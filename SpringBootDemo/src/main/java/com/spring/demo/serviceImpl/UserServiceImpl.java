package com.spring.demo.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.dao.UserRepository;
import com.spring.demo.exception.UserNotFoundException;
import com.spring.demo.model.Users;
import com.spring.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public Users saveUserDetails(Users user) {
		// TODO Auto-generated method stub
		Users userDetails = userRepository.save(user);
		return userDetails;
	}

	@Override
	public Users changePassword(Long userId,Users user) {
		// TODO Auto-generated method stub
		userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId, user.getLoginDetails().getUserName()));
		user.setUserId(userId);
		
		Users users = userRepository.save(user);
		
		return users;
	}

	@Override
	public void deleteUser(Long userId) {
		
		userRepository.deleteById(userId);
	}

	@Override
	public Users checkValidUser(String userName, String password) {
		// TODO Auto-generated method stub
		Users userDetails = userRepository.checkValidUser(userName, password);
		return userDetails;
	}

}
