package com.entryPass.ui.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entryPass.ui.model.UserDto;
import com.entryPass.ui.service.AdminUIService;

@RequestMapping("/rest/adminui")
@RestController
public class AdminUIController {

	@Autowired
	AdminUIService adminService;

	@RequestMapping("/find/{id}")
	public UserDto getUserById(@PathVariable Integer id) {
		return adminService.getUserById(id);
	}
	
	@RequestMapping("/findByUserName/{name}")
	public UserDto getUserByUserName(@PathVariable String name) {
		return adminService.getUserByName(name);
	}

	@RequestMapping("/find/all")
	public List<UserDto> getAllUsers() {
		return adminService.getAllUsers();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveUser(@RequestParam Map<String, String> userDto) {
		adminService.saveUser(userDto);
	}

}
