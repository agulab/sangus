package com.sociedad.sangus;

import java.util.HashMap;
import java.util.Map;

public enum Environment {

	LOCAL("local"),
	IC("ic"),
	BETA("beta"),
	PROD("prod"),
	TEST("test");
	
	private static final String PROPERTY_NAME = "environment";
	
	private static final Map<String, Environment> map = new HashMap<String, Environment>();
	
	private String value;
	
	private Environment(String value) {
		this.value = value;
	}
	
	static {
		for (Environment environment : Environment.values()) {
			map.put(environment.value, environment);
		}
	}
	
	public static Environment parse() {
		String environmentPropertyValue = System.getProperty(PROPERTY_NAME);
		if (environmentPropertyValue != null && !environmentPropertyValue.isEmpty()) {
			Environment environment = map.get(environmentPropertyValue);
			if (environment != null) {
				return environment;
			} else {
				return LOCAL;
			}
		} else {
			return LOCAL;
		}
	}

	@Override
	public String toString() {
		return this.value;
	}
	
}
