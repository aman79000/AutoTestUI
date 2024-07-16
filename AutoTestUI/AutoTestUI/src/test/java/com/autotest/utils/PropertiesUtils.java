package com.autotest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	Properties prop;

	public PropertiesUtils()  {
		prop = new Properties();
	try {	
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\91991\\Documents\\GitHub\\AutoTestUI\\AutoTestUI\\AutoTestUI\\src\\main\\java\\com\\autotest\\resources\\saucelabs.properties");
		prop.load(ip);}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
		
		
		public String getUrl() {
			return prop.getProperty("url");
		}
		
		public String getUserName() {
			return prop.getProperty("username");
	}
		
		public String getPassword() {
			return prop.getProperty("password");
		}
}
