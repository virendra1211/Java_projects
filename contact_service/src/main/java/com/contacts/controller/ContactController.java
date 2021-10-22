package com.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.entity.Contact;
import com.contacts.service.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping("/user/{userId}")
	public List<Contact> getContacts(@PathVariable Long userId){
		
		return contactService.getContactUser(userId);
	}
}
