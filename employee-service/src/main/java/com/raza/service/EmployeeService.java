package com.raza.service;

import com.raza.dto.ApiResponse;
import com.raza.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto saveEmployee(EmployeeDto employee);

	public ApiResponse getEmployeeById(Long id);
}
