package com.org.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.org.model.User;

public class UserPrinciple implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return Collections.singelton(new SimpleGrantedAuthority("User"))
    }

    @Override
    public String getPassword() {
	// TODO Auto-generated method stub
	return user.getPassword();
    }

    @Override
    public String getUsername() {
	// TODO Auto-generated method stub
	return user.getUserName();
    }

}
