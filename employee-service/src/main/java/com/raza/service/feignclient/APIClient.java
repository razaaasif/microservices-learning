package com.raza.service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.raza.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
	@GetMapping("api/departments/{code}")
	public DepartmentDto getDepartment(@PathVariable("code") String code);
}
