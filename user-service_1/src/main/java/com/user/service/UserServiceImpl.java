package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.User;

@Service
public class UserServiceImpl implements UserService {

	// Dummy User list
	List<User> list = List.of( new User(1112L,"Virendra",22344),new User(1114L,"raju",22341), new
	  User(1113L,"Jay",22342),new User(1115L,"Vir",22345), new
	  User(1116L,"sachin",22346),new User(1117L,"rane",22347));
	
	@Override
	public User getUser(Long id) {
		
		return this.list.stream().filter(user ->user.getUserId().equals(id)).findAny().orElse(new User(0L,"Not Available",0));
	}

}
