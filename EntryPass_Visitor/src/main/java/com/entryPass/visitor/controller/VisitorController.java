package com.entryPass.visitor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entryPass.visitor.exception.VisitorNotFoundException;
import com.entryPass.visitor.model.VisitorAddress;
import com.entryPass.visitor.model.VisitorData;
import com.entryPass.visitor.repository.VisitorRepository;

@RestController
@RequestMapping("/rest/visitor")
public class VisitorController {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	@PostMapping("/save")
	public VisitorData saveVisitorDetails(@RequestBody VisitorData visitorDetails) {
		System.out.println(visitorDetails.getFirstName());
		return visitorRepository.save(visitorDetails);		
	}
	
	@RequestMapping("/saveTempVisitor")
	public VisitorData saveVisitorDetails() {
		List<VisitorAddress> visitorAddressList = new ArrayList<>();
		VisitorAddress visitorAddress = new VisitorAddress();
		//userAddress.setAddressId((long) 1);
		visitorAddress.setAddressLine("ABC");
		visitorAddress.setAddressType("Permanent");
		visitorAddress.setCity("Pune");
		visitorAddress.setCountry("India");
		visitorAddress.setState("Maharashtra");
		visitorAddressList.add(visitorAddress);
		VisitorData visitorData = new VisitorData();
		//userData.setUserId((long) 1);
		visitorData.setVisitorAddress(visitorAddressList);
		visitorData.setFirstName("Tanveer");
		visitorData.setLastName("Hussain");
		visitorData.setPhoneNumber("789456123");
		visitorData.setEmailAddress("tan@gmail.com");
		visitorData.setPurposeOfAccess("Interview");
		return visitorRepository.save(visitorData);		
	}
	
	@GetMapping("find/{id}")
	public VisitorData findVisitorDetailsById(@PathVariable Long id) {
		return visitorRepository.findById(id).orElseThrow(()->new VisitorNotFoundException());
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE , value = "find/all")
	public List<VisitorData> getAllVisitors(){
		return  (List<VisitorData>) visitorRepository.findAll();
		
	}
	
	

}
