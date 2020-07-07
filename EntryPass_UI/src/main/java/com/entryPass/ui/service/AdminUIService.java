package com.entryPass.ui.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entryPass.ui.model.RoleDto;
import com.entryPass.ui.model.UserDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@Service
public class AdminUIService {

	private String adminService = "http://admin-service/rest/admin/";

	@Autowired
	private RestTemplate restTemplateForClass;

	public UserDto getUserById(int userId) {
		String uri = adminService + "find/" + userId;
		return restTemplateForClass.getForObject(uri, UserDto.class);
	}

	public List<UserDto> getAllUsers() {
		String uri = adminService + "find/all";
		ResponseEntity<UserDto[]> responseEntity = restTemplateForClass.getForEntity(uri, UserDto[].class);
		return Stream.of(responseEntity.getBody()).collect(Collectors.toList());
	}

	public UserDto saveUser(Map<String, String> userData) {
		String uri = adminService + "save";

		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(userData);
		RoleDto roleDto = gson.fromJson(jsonElement, RoleDto.class);
		UserDto userDto = gson.fromJson(jsonElement, UserDto.class);
		List<RoleDto> roleDtoList = new ArrayList<>();
		roleDtoList.add(roleDto);
		userDto.setRoles(roleDtoList);
		HttpEntity<UserDto> httpEntity = new HttpEntity<UserDto>(userDto);
		ResponseEntity<UserDto> responseEntity = restTemplateForClass.postForEntity(uri, httpEntity, UserDto.class);
		return responseEntity.getBody();
	}

	public UserDto getUserByName(String userName) {
		String uri = adminService+"findByName/" + userName;
		return restTemplateForClass.getForObject(uri, UserDto.class);
	}
}
