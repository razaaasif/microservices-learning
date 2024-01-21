package com.raza.employeeservice.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface Utils {
	public static void throwNullPointerException(Object obj, String message) {
		if (Objects.isNull(obj)) {
			throw new NullPointerException(message);
		}
	}

	public static <T> List<T> nullSafeMutableLists(List<T> list) {
		return list == null || list.isEmpty() ? new ArrayList<>() : list;
	}
}
