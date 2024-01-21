package com.raza.departmentservice.service.implementaion;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		Department department = this.createDepartmentEntity(departmentDto);
		logger.info("saveDepartment " + department);
		Department savedDepartment = this.departmentRepository.save(department);
		DepartmentDto response = this.createDepartmentDto(savedDepartment);

		logger.info("saveDepartment finished");
		return response;
	}

	private List<DepartmentDto> createDepartmentDtoList(List<Department> list) {
		return list.stream().map(this::createDepartmentDto).collect(Collectors.toList());
	}

	private Department createDepartmentEntity(DepartmentDto departmentDto) {
		return new Department(null, // Let the database generate the ID
				departmentDto.getDescription(), departmentDto.getCode(), departmentDto.getName());
	}

	private DepartmentDto createDepartmentDto(Department savedDepartment) {
		return new DepartmentDto(savedDepartment.getId(), savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode());
	}

	@Override
	public List<DepartmentDto> getByDepartmentCode(String code) {
		return this.createDepartmentDtoList(this.departmentRepository.getByDepartmentCode(code));
	}
}
