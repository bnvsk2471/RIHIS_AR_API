package com.rhode.app.Binding;

import lombok.Data;

@Data
public class CitizenApp {
	
	private String fullName;
	private String email;
	private String mobileNumber;
	private String gender; 
	private String dob;
	private Long SSN;
	private Integer createdBy;
	private Integer updatedBy;

}
