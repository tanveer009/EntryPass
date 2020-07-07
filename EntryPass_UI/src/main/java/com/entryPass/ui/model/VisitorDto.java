package com.entryPass.ui.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VisitorDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long visitorId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String purposeOfAccess;
	private List<VisitorAddressDto> visitorAddress;
	
	public VisitorDto() {
		
	}
	public Long getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPurposeOfAccess() {
		return purposeOfAccess;
	}
	public void setPurposeOfAccess(String purposeOfAccess) {
		this.purposeOfAccess = purposeOfAccess;
	}
	public List<VisitorAddressDto> getVisitorAddress() {
		return visitorAddress;
	}
	public void setVisitorAddress(List<VisitorAddressDto> visitorAddress) {
		this.visitorAddress = visitorAddress;
	}
	

}
