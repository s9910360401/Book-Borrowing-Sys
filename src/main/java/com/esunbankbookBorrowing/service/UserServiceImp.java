package com.esunbankbookBorrowing.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esunbankbookBorrowing.entity.UserEntity;
import com.esunbankbookBorrowing.repository.UserRepo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public boolean login(String phoneNumber, String password) {
		
		UserEntity temp = userRepo.findByPhoneNumber(phoneNumber);
		
		if(temp!=null && passwordEncoder.matches(password, temp.getPassword()) ) {
	        temp.setLastloginTime(new Timestamp(System.currentTimeMillis()));
	        userRepo.save(temp);
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public UserEntity getUserByPhone(String phoneNumber) {		
		
		return userRepo.findByPhoneNumber(phoneNumber);
	}

	@Override
	public void register(UserEntity user) {
		
		//密碼進資料庫前的加鹽(salt)並經雜湊(Hash)
		String enocodePassword = passwordEncoder.encode(user.getPassword()); 
		user.setPassword(enocodePassword); 
		userRepo.save(user);
	}

}
