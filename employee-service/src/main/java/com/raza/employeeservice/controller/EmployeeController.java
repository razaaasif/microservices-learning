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

import com.raza.employeeservice.dto.EmployeeAndDepartment;
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
	public ResponseEntity<EmployeeAndDepartment> getById(@PathVariable("id") Long id) {
		try {
			System.out.println("getById() Id -> " + id);
			EmployeeAndDepartment dto = this.employeeService.getEmployeeById(id);
			return new ResponseEntity<>(dto, HttpStatus.FOUND);
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping
	public ResponseEntity<EmployeeDto> persist(@RequestBody EmployeeDto dto) {
		System.out.println("Save Dto => " + dto);
		return new ResponseEntity<>(this.employeeService.saveEmployee(dto), HttpStatus.CREATED);
	}

}
