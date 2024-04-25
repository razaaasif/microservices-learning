package com.raza.department.service;

import com.raza.department.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto toSave);
	DepartmentDto getDepartmentByCode(String id);
}
