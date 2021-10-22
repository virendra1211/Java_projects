package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.Contact;
import com.user.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		User user = userService.getUser(userId);
		// http://localhost:9002/contact/user/1112
		//List<Contact> listContact = restTemplate.getForObject("http://localhost:9002/contact/user/"+user.getUserId(),List.class);
		List<Contact> listContact = restTemplate.getForObject("http://CONTACT-SERVICE/contact/user/"+user.getUserId(),List.class);
		
		// here we can use host which we have registered in eureca server like CONTACT-SERVICE
		user.setContacts(listContact);
		return user;
	}
	
	@RequestMapping("/welcome")
	public String welcomepage() {
		return "Welcome to Advance Tutor";
	}
	
}
