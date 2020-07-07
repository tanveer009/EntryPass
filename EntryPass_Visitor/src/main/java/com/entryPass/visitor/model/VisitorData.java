package com.entryPass.visitor.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class VisitorData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long visitorId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String phoneNumber;
	@Column
	private String emailAddress;
	@Column
	private String purposeOfAccess;
	@OneToMany(cascade = CascadeType.ALL)
	private List<VisitorAddress> visitorAddress;

	public VisitorData() {

	}

	public List<VisitorAddress> getVisitorAddress() {
		return visitorAddress;
	}

	public void setVisitorAddress(List<VisitorAddress> visitorAddress) {
		this.visitorAddress = visitorAddress;
	}

	public Long getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Long userId) {
		this.visitorId = userId;
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

}
