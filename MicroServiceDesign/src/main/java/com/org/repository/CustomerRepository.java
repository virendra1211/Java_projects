package com.org.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.model.User;

public interface CustomerRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

    User findById(long id);
}