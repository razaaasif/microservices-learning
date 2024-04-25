package com.raza.dto;

public class ApiResponse {
	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;

	public ApiResponse() {
	}

	public ApiResponse(EmployeeDto employeeDto, DepartmentDto departmentDto) {
		this.employeeDto = employeeDto;
		this.departmentDto = departmentDto;
	}

	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

}
