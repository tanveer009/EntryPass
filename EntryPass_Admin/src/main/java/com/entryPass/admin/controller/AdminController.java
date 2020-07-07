package com.entryPass.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entryPass.admin.exception.UserNotFoundException;
import com.entryPass.admin.model.User;
import com.entryPass.admin.repository.UserRepository;

@RestController
@RequestMapping("/rest/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/save")
	public User saveUserDetails(@RequestBody User visitorDetails) {
		return userRepository.save(visitorDetails);
	}

	@GetMapping("find/{id}")
	public User findUserDetailsById(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
	}

	@GetMapping("findByName/{name}")
	public User findUserDetailsName(@PathVariable String name) {
		return userRepository.findByUserName(name).orElseThrow(() -> new UserNotFoundException());
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "find/all")
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();

	}

}
