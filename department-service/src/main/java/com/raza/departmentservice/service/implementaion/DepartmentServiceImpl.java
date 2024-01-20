package com.raza.departmentservice.service.implementaion;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raza.departmentservice.contoller.DepartmentController;
import com.raza.departmentservice.dto.DepartmentDto;
import com.raza.departmentservice.entity.Department;
import com.raza.departmentservice.repository.DepartmentRepository;
import com.raza.departmentservice.service.service.DepartmentService;

@Repository
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
	private static Logger logger = Logger.getLogger(DepartmentServiceImpl.class.getName());

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert departmentDto to Department
        Department department = new Department(
                null, // Let the database generate the ID
                departmentDto.getDescription(),
                departmentDto.getCode(),
                departmentDto.getName()
        );
        logger.info("saveDepartment " + department);
        Department savedDepartment = this.departmentRepository.save(department);
        DepartmentDto response = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentcode()
        );

        return response;
    }
}

