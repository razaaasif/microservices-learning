package com.raza.departmentservice.service.service;

import java.util.List;

import com.raza.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	public DepartmentDto saveDepartment(DepartmentDto departmentDto);

	public List<DepartmentDto> getByDepartmentCode(String code);
}
