package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
