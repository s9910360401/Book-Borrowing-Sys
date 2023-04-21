package com.esunbankbookBorrowing.service;

import org.springframework.stereotype.Service;

import com.esunbankbookBorrowing.entity.UserEntity;


public interface UserService {

	boolean login(String phoneNumber, String password);
	UserEntity getUserByPhone(String phoneNumber);
	void register(UserEntity user);
	
	
}
