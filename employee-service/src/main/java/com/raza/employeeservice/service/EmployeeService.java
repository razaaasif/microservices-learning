package com.raza.employeeservice.service;

import com.raza.employeeservice.dto.EmployeeAndDepartment;
import com.raza.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto saveEmployee(EmployeeDto dto);

	public EmployeeAndDepartment getEmployeeById(Long id);
}
