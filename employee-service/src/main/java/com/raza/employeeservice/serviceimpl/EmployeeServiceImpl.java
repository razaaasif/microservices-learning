package com.raza.employeeservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raza.employeeservice.dto.EmployeeDto;
import com.raza.employeeservice.entity.Employee;
import com.raza.employeeservice.repository.EmployeeRepository;
import com.raza.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		if (null == dto) {
			throw new NullPointerException("CAN_CREATE_WITH_NULL_ENTITY");
		}
		Employee employee = this.employeeRepository.save(this.createEmployee(dto));
		return this.createEmployeeDto(employee);
	}

	private Employee createEmployee(EmployeeDto dto) {
		return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
	}

	private EmployeeDto createEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	}

	@Override
	public EmployeeDto getById(Long id) {
		Employee employee = this.employeeRepository.getReferenceById(id);
		return this.createEmployeeDto(employee);
	}

}
