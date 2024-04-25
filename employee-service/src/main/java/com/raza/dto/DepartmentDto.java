package com.raza.dto;

public class DepartmentDto {
	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;

	public DepartmentDto() {
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

}
