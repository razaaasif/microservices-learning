package com.raza.employeeservice.service;

import com.raza.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto saveEmployee(EmployeeDto dto);
	public EmployeeDto getById(Long id);
}
