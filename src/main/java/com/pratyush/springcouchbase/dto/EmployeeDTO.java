package com.pratyush.springcouchbase.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDTO {
	
	private Integer empId;
	
	@NotBlank
	private String empName;
	
	@Email
	private String empEmail;
	
	@NotBlank
	private String empMobileNum;
	
	@NotBlank
	private List<String> empAddress;
	
	@NotBlank
	private String empPosition;
	
	@NotBlank
	private String jobLevel;

}
