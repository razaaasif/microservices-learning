package com.raza.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raza.employeeservice.dto.EmployeeDto;
import com.raza.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id) {
		EmployeeDto dto = this.employeeService.getById(id);
		return new ResponseEntity<>(dto, HttpStatus.FOUND);

	}

	@PostMapping
	public ResponseEntity<EmployeeDto> persist(@RequestBody EmployeeDto dto) {
		System.out.println("Save Dto => " + dto);
		return new ResponseEntity<>(this.employeeService.saveEmployee(dto), HttpStatus.CREATED);
	}

}
