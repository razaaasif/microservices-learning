package com.raza.department.dto;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raza.department.entity.Department;


public class DepartmentDto {
	@JsonProperty
	private Long id;
	@JsonProperty
	private String departmentName;
	@JsonProperty
	private String departmentDescription;
	@JsonProperty
	private String departmentCode;

	public DepartmentDto() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentCode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentCode = departmentCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentDto [id=");
		builder.append(id);
		builder.append(", departmentName=");
		builder.append(departmentName);
		builder.append(", departmentDescription=");
		builder.append(departmentDescription);
		builder.append(", departmentCode=");
		builder.append(departmentCode);
		builder.append("]");
		return builder.toString();
	}

	public static DepartmentDto getDepartmentDto(Department toSave) {
		return new DepartmentDto(toSave.getId(), toSave.getDepartmentName(), toSave.getDepartmentDescription(),
				toSave.getDepartmentCode());
	}

	public static Department getDepartment(DepartmentDto toSave) {
		return new Department(toSave.getId(), toSave.getDepartmentName(), toSave.getDepartmentDescription(),
				toSave.getDepartmentCode());
	}

}
