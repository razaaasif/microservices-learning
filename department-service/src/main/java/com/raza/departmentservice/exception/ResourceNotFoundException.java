package com.raza.departmentservice.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String name) {
		super(name);
	}
}
