package com.backend.v1.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertiesUtil {
	private static Environment env;
	
	@Autowired
	public void setEnvironment(Environment env) {
		this.env = env;
	}


    public static String getProperty(String key) {
        return env.getProperty(key);
  }


	public String[] getArrayProperty(String key, Class<String[]> class1) {
		return env.getProperty(key, String[].class);
	}
}
