package com.entryPass.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entryPass.ui.model.CustomUserDetails;
import com.entryPass.ui.model.UserDto;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminUIService adminService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = adminService.getUserByName(username);
		CustomUserDetails customUserDetails= new CustomUserDetails(user);
		return customUserDetails;
	}
	
	
	

}
