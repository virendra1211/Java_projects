package com.user;

public class Contact {
	private Long cId;
	private String name;
	private String contactName;
	private Long userId;
	public Contact(Long cId, String name, String contactName, Long userId) {
		this.cId = cId;
		this.name = name;
		this.contactName = contactName;
		this.userId = userId;
	}
	public Contact() {
	}
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
