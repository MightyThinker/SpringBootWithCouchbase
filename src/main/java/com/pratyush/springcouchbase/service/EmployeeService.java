package com.pratyush.springcouchbase.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratyush.springcouchbase.entity.EmployeeEntity;
import com.pratyush.springcouchbase.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

//	@Autowired
//	private SourceDestinationMapper srcDstnMap;

//    @Autowired
//    public EmployeeService(EmployeeRepository empRepo) {
//        this.empRepo = empRepo;
//    }

	@PostConstruct
	public void initData() {
		log.info("--Initilizing Data from Post Construct--");
		System.err.println("From Service Class : --Initilizing Data from Post Construct--");
		empRepo.saveAll(Arrays.asList(
				new EmployeeEntity(1, "John Doe", "john.doe@example.com", "1234567890",
						Arrays.asList("123 Main St", "Apt 4B"), "Developer", "Junior"),
				new EmployeeEntity(2, "Jane Doe", "jane.doe@example.com", "0987654321",
						Arrays.asList("456 Elm St", "Apt 12C"), "Designer", "Mid"),
				new EmployeeEntity(3, "Jim Beam", "jim.beam@example.com", "1112233445",
						Arrays.asList("789 Maple St", "Apt 8D"), "Manager", "Senior")));
	}

	public List<EmployeeEntity> findAll() {
		log.info("--Find All Employees data--");
		System.err.println("From Service Class : --Find All Employees data--");
		List<EmployeeEntity> employees = empRepo.findAll();
//		List<EmployeeDTO> employeeDTOs = employees.stream().map(SourceDestinationMapper.INSTANCE::toEmployeeDTO)
//				.collect(Collectors.toList());
		return employees;
	}

	public EmployeeEntity findById(Integer id) {
		log.info("--Find Employee data by ID--");
		System.err.println("From Service Class : --Find Employee data by ID--");
		Optional<EmployeeEntity> employee = empRepo.findById(id);
		return employee.orElse(null);
//		return employee.map(SourceDestinationMapper.INSTANCE::toEmployeeDTO).orElse(null);
	}

	public EmployeeEntity save(EmployeeEntity employeeEntity) {
		log.info("--Update Employee data by ID--");
		System.err.println("From Service Class : --Update Employee data by ID--");
//		EmployeeEntity employeeEntity = SourceDestinationMapper.INSTANCE.toEmployeeEntity(employeeDTO);
		EmployeeEntity savedEmployee = empRepo.save(employeeEntity);
		return savedEmployee;
//		return SourceDestinationMapper.INSTANCE.toEmployeeDTO(savedEmployee);
	}

	public void deleteById(Integer id) {
		log.info("--Delete Employee data by ID--");
		System.err.println("From Service Class : --Delete Employee data by ID--");
		Optional<EmployeeEntity> employee = empRepo.findById(id);
		if(employee.isPresent())
			empRepo.deleteById(id);
		else
			System.err.println("--Employee Not found--");
	}

}
