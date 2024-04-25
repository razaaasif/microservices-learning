package com.raza.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raza.dto.ApiResponse;
import com.raza.dto.EmployeeDto;
import com.raza.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController() {
	}

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable("id") Long id) {
		ApiResponse employee = this.employeeService.getEmployeeById(id);
		return new ResponseEntity<ApiResponse>(employee, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto saved = this.employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(saved, HttpStatus.CREATED);
	}

}
