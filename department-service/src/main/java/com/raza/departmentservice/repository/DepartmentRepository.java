package com.raza.departmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raza.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public List<Department> getByDepartmentCode(String code);

}
