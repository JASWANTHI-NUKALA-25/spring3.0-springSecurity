package com.springSecurity.springSecurity.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springSecurity.springSecurity.model.UserData;
import com.springSecurity.springSecurity.repository.UserInfoRepository;
import com.springSecurity.springSecurity.security.UserInfoUserDetails;
import com.springSecurity.springSecurity.security.Exception.UserNameNotFoundException;

@Service
public class UserInfoUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository infoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserData> userInfo =infoRepository.findByName(username);
		
	return	userInfo.map(UserInfoUserDetails::new).orElseThrow(()-> new UserNameNotFoundException("userNotFound"));
		
		
	}

}
