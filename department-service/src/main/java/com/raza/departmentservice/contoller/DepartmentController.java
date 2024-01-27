package com.raza.departmentservice.contoller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raza.departmentservice.dto.DepartmentDto;
import com.raza.departmentservice.service.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	private DepartmentService departmentService;
	private static Logger logger = Logger.getLogger(DepartmentController.class.getName());

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping
	public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto dto) {
		logger.info("Starts Data " + dto);
		return new ResponseEntity<>(this.departmentService.saveDepartment(dto), HttpStatus.CREATED);
	}

	@GetMapping("/{code}")
	public ResponseEntity<DepartmentDto> getByCode(@PathVariable("code") String code) {
		logger.info("Code -> " + code);
		return new ResponseEntity<>(this.departmentService.getByDepartmentCode(code).get(0), HttpStatus.OK);
	}
}
