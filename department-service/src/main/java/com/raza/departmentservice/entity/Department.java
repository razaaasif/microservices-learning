package com.raza.departmentservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String departmentName;
	@Column
	private String departmentDescription;
	@Column
	private String departmentCode;

	public Department() {
	}

	public Department(Long id, String description, String code, String name) {
		this.id = id;
		this.departmentDescription = description;
		this.departmentCode = code;
		this.departmentName = name;
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

	public void setDepartmentCode(String departmentcode) {
		this.departmentCode = departmentcode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [id=");
		builder.append(id);
		builder.append(", departmentName=");
		builder.append(departmentName);
		builder.append(", departmentDescription=");
		builder.append(departmentDescription);
		builder.append(", departmentcode=");
		builder.append(departmentCode);
		builder.append("]");
		return builder.toString();
	}

}
