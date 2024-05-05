package com.raza.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raza.department.dto.DepartmentDto;
import com.raza.department.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public DepartmentDto saveDepartment(@RequestBody DepartmentDto toSave) {
		System.out.println(toSave);
		return departmentService.saveDepartment(toSave);
	}

	@GetMapping("{code}")
	public DepartmentDto getDepartmentByCode(@PathVariable String code) {
		return this.departmentService.getDepartmentByCode(code);
	}

}
