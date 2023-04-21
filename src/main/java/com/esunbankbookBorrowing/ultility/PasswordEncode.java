package com.esunbankbookBorrowing.ultility;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncode {
	
	@Bean 
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
