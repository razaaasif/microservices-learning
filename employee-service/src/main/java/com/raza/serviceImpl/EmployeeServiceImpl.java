package com.raza.serviceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.raza.dto.ApiResponse;
import com.raza.dto.DepartmentDto;
import com.raza.dto.EmployeeConvertor;
import com.raza.dto.EmployeeDto;
import com.raza.entity.Employee;
import com.raza.repository.EmployeeRepository;
import com.raza.service.EmployeeService;
import com.raza.service.feignclient.APIClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final APIClient apiClient;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, APIClient apiClient) {
		this.employeeRepository = employeeRepository;
		this.apiClient = apiClient;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeConvertor.getEmployee(employeeDto);
		employee = this.employeeRepository.save(employee);
		return EmployeeConvertor.getEmployeeDto(employee);
	}

	@Override
	public ApiResponse getEmployeeById(Long id) {
		Employee emp = this.employeeRepository.findById(id).orElseGet(null);
		DepartmentDto departmentDto = null ;
		if(emp != null && emp.getDepartmentCode() != null)
        	departmentDto = apiClient.getDepartment(emp.getDepartmentCode());
		return new ApiResponse(EmployeeConvertor.getEmployeeDto(emp), departmentDto);
	}

}
