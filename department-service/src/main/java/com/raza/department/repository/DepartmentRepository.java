package com.raza.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raza.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByDepartmentCode(String code);
}
