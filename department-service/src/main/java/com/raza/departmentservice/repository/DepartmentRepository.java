package com.raza.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raza.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
