package com.org.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.org.model.User;

public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    MyUserDetailsService(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	User user = return userRepository.findByUsername(username);
	if(user == null) {
	    throw new UsernameNotFoundException("user Not Exist");
	}
	
	return user;
	
    }

}
