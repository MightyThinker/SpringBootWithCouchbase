package com.pratyush.springcouchbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pratyush.springcouchbase.entity.EmployeeEntity;
import com.pratyush.springcouchbase.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	    @Autowired
//	    public EmployeeController(EmployeeService employeeService) {
//	        this.employeeService = employeeService;
//	    }

	@GetMapping("/get-all")
	public List<EmployeeEntity> getAllEmployees() {
		log.info("--Find all Employees data--");
		System.err.println("From Controller Class : --Find all Employees data--");
		return employeeService.findAll();
	}

	@GetMapping("/{id}")
	public EmployeeEntity getEmployeeById(@PathVariable("id") Integer id) {
		log.info("--Find Employee data by ID--");
		System.err.println("From Controller Class : --Find Employee data by ID--");
//		EmployeeDTO employeeDTO = employeeService.findById(id);
		EmployeeEntity empEntity = employeeService.findById(id);
		if (empEntity == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + id);
		}
		return empEntity;
	}

	@PostMapping
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
		log.info("--Create Employees data--");
		System.err.println("From Controller Class : --Create Employees data--");
		if (employeeEntity.getEmpId() != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Employee ID must not be provided for new employees.");
		}
		return employeeService.save(employeeEntity);
	}

	@PutMapping("/{id}")
	public EmployeeEntity updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeEntity employeeEntity) {
		log.info("--Update Employees data--");
		System.err.println("From Controller Class : --Update Employees data--");
		if (employeeEntity.getEmpId() == null || !employeeEntity.getEmpId().equals(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Employee ID in path and request body must match.");
		}
		return employeeService.save(employeeEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		log.info("--Delete Employees data--");
		System.err.println("From Controller Class : --Delete Employees data--");
		employeeService.deleteById(id);
	}

}
