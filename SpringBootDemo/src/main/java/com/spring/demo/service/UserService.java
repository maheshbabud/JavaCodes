package com.spring.demo.service;

import com.spring.demo.model.Users;


public interface UserService {
	
	public Users saveUserDetails(Users user);
	
	public Users changePassword(Long userId , Users user);
	
	public void deleteUser(Long userId);
	
	public Users checkValidUser(String userName,String password);
}
