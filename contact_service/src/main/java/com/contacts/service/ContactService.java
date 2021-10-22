package com.contacts.service;

import java.util.ArrayList;
import java.util.List;

import com.contacts.entity.Contact;

public interface ContactService {
	 
	public List<Contact> getContactUser(Long userId);
}
