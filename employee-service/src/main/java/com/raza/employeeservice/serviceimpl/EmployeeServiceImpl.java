package com.raza.employeeservice.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.raza.employeeservice.dto.DepartmentDto;
import com.raza.employeeservice.dto.EmployeeAndDepartment;
import com.raza.employeeservice.dto.EmployeeDto;
import com.raza.employeeservice.entity.Employee;
import com.raza.employeeservice.repository.EmployeeRepository;
import com.raza.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final RestTemplate restTemplate;
	private final Environment environment;

	private static final String DEPARTMENT_URL = "DEPARTMENT_URL";

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, RestTemplate restTemplate,
			Environment environment) {

		this.employeeRepository = employeeRepository;
		this.restTemplate = restTemplate;
		this.environment = environment;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		logger.info("saveEmployee start() ");
		if (null == dto) {
			throw new NullPointerException("CAN_CREATE_WITH_NULL_ENTITY");
		}
		Employee employee = this.employeeRepository.save(this.createEmployee(dto));
		logger.info("saveEmployee finishes() ");
		return this.createEmployeeDto(employee);
	}

	@Override
	public EmployeeAndDepartment getEmployeeById(Long id) {
		EmployeeDto dto = this.createEmployeeDto(this.employeeRepository.getReferenceById(id));
		String url = environment.getProperty(DEPARTMENT_URL) + dto.getDepartmentCode();
		System.out.println("URL DEPARTMENT -> " + url);

		DepartmentDto department = this.restTemplate.getForEntity(url, DepartmentDto.class).getBody();

		return new EmployeeAndDepartment(dto, department);
	}

	private Employee createEmployee(EmployeeDto dto) {
		return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(),
				dto.getDepartmentCode());
	}

	private EmployeeDto createEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(),
				employee.getDepartmentCode());
	}

}
