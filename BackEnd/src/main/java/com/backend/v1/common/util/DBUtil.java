package com.backend.v1.common.util;

public class DBUtil {
	public static String statement(Class<?> clazz, String sqlId) {
		return clazz.getName() + "." + sqlId;
	}
}
