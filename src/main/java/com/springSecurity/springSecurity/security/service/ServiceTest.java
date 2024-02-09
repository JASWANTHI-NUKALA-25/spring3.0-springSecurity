package com.springSecurity.springSecurity.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springSecurity.springSecurity.model.UserData;
import com.springSecurity.springSecurity.repository.UserInfoRepository;

@Service
public class ServiceTest {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public String addUser(UserData userData) {
		userData.setPassword(passwordEncoder.encode(userData.getPassword()));
		userInfoRepository.save(userData);
		return "user Added Succesfully";
	}

}
