package com.raza.department.serviceImpl;

import org.springframework.stereotype.Service;
import com.raza.department.dto.DepartmentDto;
import com.raza.department.entity.Department;
import com.raza.department.repository.DepartmentRepository;
import com.raza.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto toSave) {
		Department department = this.departmentRepository.save(DepartmentDto.getDepartment(toSave));
		System.out.println("Saved Data : " + department);
		DepartmentDto dto = DepartmentDto.getDepartmentDto(department);
		System.out.println("Saved DTO : " + dto);
		return dto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		Department department = this.departmentRepository.findByDepartmentCode(code);
		return new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());
	}

}
