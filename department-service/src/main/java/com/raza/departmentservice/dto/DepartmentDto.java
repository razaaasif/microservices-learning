package com.raza.departmentservice.dto;

public class DepartmentDto {
	private Long id;
	private String name;
	private String description;
	private String code;

	public DepartmentDto() {
	}

	public DepartmentDto(Long id, String name, String description, String code) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentDto [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}

	
}
