package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.dto.ResponseDTO;
import com.spring.demo.model.Users;
import com.spring.demo.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public ResponseEntity<ResponseDTO> saveUserDetails(@RequestBody Users user){
		ResponseDTO responseDTO = new ResponseDTO();
		Users userDetails = userService.saveUserDetails(user);
		if(userDetails != null){
			responseDTO.setMessage("User Created Successfully with User Name : " + user.getLoginDetails().getUserName());
			responseDTO.setStatus_code(201);
			return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
		}else{
			responseDTO.setStatus_code(500);
			responseDTO.setMessage("User Registration Failed.");
			return new ResponseEntity<>(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping(value="/change/password/{userId}")
	public ResponseEntity<ResponseDTO> changePassword(@PathVariable(name="userId") Long userId, @RequestBody Users user){
		ResponseDTO responseDTO = new ResponseDTO();
		userService.changePassword(userId, user);
		responseDTO.setMessage("Password Changed Successfully for User : "+user.getLoginDetails().getUserName());
		responseDTO.setStatus_code(200);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("userId") Long userId){
		
		ResponseDTO responseDTO = new ResponseDTO();
		userService.deleteUser(userId);
		responseDTO.setMessage("User Deleted");
		responseDTO.setStatus_code(200);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/user/valid")
	public ResponseEntity<ResponseDTO> checkValidUser(@RequestParam("userName") String userName,@RequestParam("password") String password){
		ResponseDTO responseDTO = new ResponseDTO();

		Users userDetails = userService.checkValidUser(userName, password);
		if(userDetails != null){
			responseDTO.setMessage("Login Success");
			responseDTO.setStatus_code(200);
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}else{
			responseDTO.setMessage("Login Failed");
			responseDTO.setStatus_code(400);
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
		}
	}
}
