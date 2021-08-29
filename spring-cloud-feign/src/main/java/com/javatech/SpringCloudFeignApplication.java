package com.javatech;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatech.client.UserClient;
import com.javatech.pojo.UserResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringCloudFeignApplication {

	@Autowired
	private UserClient client;
	// my question to apurva how to use in service the same thing
	
	@GetMapping("/findAllUser")
	public List<UserResponse> getAllUsers(){
		return client.getUsers();
	}
	
	@GetMapping("/findAllUser/{id}")
	public UserResponse getAllUsers(@PathVariable(value = "id") String id){
		return client.getUsersId(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApplication.class, args);
	}

}
