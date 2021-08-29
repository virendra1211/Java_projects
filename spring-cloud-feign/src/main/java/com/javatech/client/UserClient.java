package com.javatech.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javatech.pojo.UserResponse;

@FeignClient(url="https://jsonplaceholder.typicode.com",name="USERCLIENT")
public interface UserClient {

	@GetMapping("/users")
	public List<UserResponse> getUsers();
	
	@GetMapping("/users/{id}")
	public UserResponse getUsersId(@PathVariable(value = "id") String id);
	
}
