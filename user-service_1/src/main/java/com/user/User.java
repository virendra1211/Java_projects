package com.user;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Long userId;
	private String name;
	private Integer phone;

	List<Contact> contacts = new ArrayList<Contact>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public User(Long userId, String name, Integer phone, List<Contact> contacts) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.contacts = contacts;
	}

	public User(Long userId, String name, Integer phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}

}
