package com.raza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raza.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
