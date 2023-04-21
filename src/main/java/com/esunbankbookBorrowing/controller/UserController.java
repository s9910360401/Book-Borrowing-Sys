package com.esunbankbookBorrowing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esunbankbookBorrowing.entity.UserEntity;
import com.esunbankbookBorrowing.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserEntity user, HttpSession session) {
				
		if(userService.login(user.getPhoneNumber(), user.getPassword())) {
			session.setAttribute("user", userService.getUserByPhone(user.getPhoneNumber()));			
			return new ResponseEntity<>("登入成功", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("登入失敗!", HttpStatus.BAD_REQUEST);
		}		
	}	
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserEntity user){
		
		if(userService.getUserByPhone(user.getPhoneNumber())==null) {
			userService.register(user);
			return new ResponseEntity<>("註冊成功!", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("註冊失敗!", HttpStatus.BAD_REQUEST);
		}
	}
}
