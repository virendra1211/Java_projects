package com.contacts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contacts.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	public List<Contact> contacts = List.of(new Contact(11L,"virendra@gmail.com","Virendra",1112L),
			new Contact(12L,"rane@gmail.com","rane",1117L),new Contact(13L,"vir@gmail.com","vir",2235L));
	
	
	@Override
	public List<Contact> getContactUser(Long userId) {

		return contacts.stream().filter(p -> p.getUserId().equals(userId)).collect(Collectors.toList());
				
	}

}
