package com.raza.employeeservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.raza.employeeservice.dto.DepartmentDto;

@FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
public interface DepartmentClient {
    @GetMapping(value = "/api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable("code") String departmentId);
}