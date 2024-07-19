package com.pratyush.springcouchbase;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document
public class EmployeeEntity {
	
	@Id
	private Integer empId;
	
	@Field
	private String empName;
	
	@Field
	private String empEmail;
	
	@Field
	private String empMobileNum;
	
	@Field
	private List<String> empAddress;
	
	@Field
	private String empPosition;
	
	@Field
	private String jobLevel;
}
