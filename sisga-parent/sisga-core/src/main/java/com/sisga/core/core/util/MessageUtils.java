package com.sisga.core.core.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MessageUtils{
	
	public static final String INFO = "INFO";
	public static final String WARN = "WARN";
	public static final String ERROR = "ERROR";
	
	private static Map<String,String> propertiesMap;
	
	
	public static String getMessage(String key, String level, Object object) {
		String message = null;
		try {
			initMap();
			Properties prop = new Properties();
			InputStream in = object.getClass().getResourceAsStream(propertiesMap.get(level));
			prop.load(in);
			in.close();			
			message = prop.getProperty(key);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	private static void initMap() {
		if(propertiesMap == null) {
			propertiesMap = new HashMap();
			propertiesMap.put(INFO, "/messages/info.properties");
			propertiesMap.put(WARN, "/messages/warning.properties");
			propertiesMap.put(ERROR, "/messages/error.properties");
		}
	}
}
