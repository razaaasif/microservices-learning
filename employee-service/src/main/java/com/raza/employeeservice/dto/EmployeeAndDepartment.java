package com.raza.employeeservice.dto;

public class EmployeeAndDepartment {
	private EmployeeDto employee;
	private DepartmentDto departmentDto;

	public EmployeeAndDepartment() {
		// Auto-generated constructor stub
	}

	public EmployeeAndDepartment(EmployeeDto employee, DepartmentDto departmentDto) {
		this.employee = employee;
		this.departmentDto = departmentDto;
	}

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

}
