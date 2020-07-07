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

import com.entryPass.ui.model.VisitorAddressDto;
import com.entryPass.ui.model.VisitorDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@Service
public class VisitorUIService {
	private String visitorService = "http://visitor-service/rest/visitor/";

	@Autowired
	private RestTemplate restTemplateForClass;

	public VisitorDto getVisitorById(int visitorId) {
		String uri = visitorService + "find/" + visitorId;
		return restTemplateForClass.getForObject(uri, VisitorDto.class);
	}

	public List<VisitorDto> getAllVisitors() {
		String uri = visitorService + "find/all";
		ResponseEntity<VisitorDto[]> responseEntity = restTemplateForClass.getForEntity(uri, VisitorDto[].class);
		return Stream.of(responseEntity.getBody()).collect(Collectors.toList());
	}

	public VisitorDto saveVisitor(Map<String, String> visitorDto) {
		String uri = visitorService + "save";

		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(visitorDto);
		VisitorAddressDto addressPojo = gson.fromJson(jsonElement, VisitorAddressDto.class);
		VisitorDto pojo = gson.fromJson(jsonElement, VisitorDto.class);
		List<VisitorAddressDto> addressPojoList = new ArrayList<>();
		addressPojoList.add(addressPojo);
		pojo.setVisitorAddress(addressPojoList);
		HttpEntity<VisitorDto> httpEntity = new HttpEntity<VisitorDto>(pojo);
		ResponseEntity<VisitorDto> responseEntity = restTemplateForClass.postForEntity(uri, httpEntity,
				VisitorDto.class);
		return responseEntity.getBody();
	}

}
