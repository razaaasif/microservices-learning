package com.raza.dto;

import com.raza.entity.Employee;

public class EmployeeConvertor {
	private EmployeeConvertor() {
	}

	public static Employee getEmployee(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail() , employeeDto.getDepartmentCode());
	}

	public static EmployeeDto getEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(),
				employee.getDepartmentCode());
	}
}
