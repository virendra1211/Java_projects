package com.org.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.org.dao.UserRepository;
import com.org.model.User;

public class MyUserDetailsService {
	private final UserRepository userRepository;

	MyUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	User user = return userRepository.findAllById(username);
	if(user == null) {
	    throw new UsernameNotFoundException("user Not Exist");
	}
	
	return user;
    }

	public void save(User user) {
		userRepository.save(user);
	}

}
